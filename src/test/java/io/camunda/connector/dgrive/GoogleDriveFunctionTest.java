package io.camunda.connector.dgrive;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.readString;

import com.google.gson.Gson;
import io.camunda.connector.api.ConnectorContext;
import io.camunda.connector.test.ConnectorContextBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GoogleDriveFunctionTest {

  private static final String SUCCESS_CASES_RESOURCE_PATH =
      "src/test/resources/requests/success-test-cases.json";

  private GoogleDriveFunction functionUnderTest;

  @BeforeEach
  void setup() {
    functionUnderTest = new GoogleDriveFunction();
  }

  @ParameterizedTest(name = "Executing test case: {0}")
  @MethodSource("successCases")
  void shouldReturnResult_WhenExecuted(final String input) throws Exception {
    final ConnectorContext ctx =
        ConnectorContextBuilder.create().variables(input).secret("GDRIVE_BEARER", "abcde").build();
    functionUnderTest.execute(ctx);
  }

  private static Stream loadTestCasesFromResourceFile(final String fileWithTestCasesUri)
      throws IOException {
    final String cases = readString(new File(fileWithTestCasesUri).toPath(), UTF_8);
    final Gson testingGson = new Gson();
    ArrayList array = testingGson.fromJson(cases, ArrayList.class);
    return array.stream().map(x -> testingGson.toJson(x)).map(Arguments::of);
  }

  private static Stream successCases() throws IOException {
    return loadTestCasesFromResourceFile(SUCCESS_CASES_RESOURCE_PATH);
  }
}
