package io.camunda.connector.dgrive;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.camunda.connector.api.ConnectorContext;
import io.camunda.connector.api.ConnectorFunction;
import io.camunda.connector.api.Validator;
import io.camunda.connector.dgrive.model.GoogleDriveRequest;
import io.camunda.connector.dgrive.model.GoogleDriveResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleDriveFunction implements ConnectorFunction {
  private static final Logger LOGGER = LoggerFactory.getLogger(GoogleDriveFunction.class);

  private static final Gson GSON = new GsonBuilder().create();

  @Override
  public Object execute(ConnectorContext context) throws Exception {
    var requestAsJson = context.getVariables();
    final var connectorRequest = GSON.fromJson(requestAsJson, GoogleDriveRequest.class);

    var validator = new Validator();
    connectorRequest.validateWith(validator);
    validator.evaluate();

    connectorRequest.replaceSecrets(context.getSecretStore());

    return executeConnector(connectorRequest);
  }

  private GoogleDriveResult executeConnector(final GoogleDriveRequest connectorRequest) {
    // TODO: implement connector logic
    LOGGER.info("Executing my connector with request {}", connectorRequest);
    var result = new GoogleDriveResult();
    result.setMyProperty("NOT_IMPLEMENTED_YET");
    return result;
  }
}
