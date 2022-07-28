package io.camunda.connector.dgrive.model;

import java.util.Objects;

public class AuthenticationParam {
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthenticationParam that = (AuthenticationParam) o;
    return Objects.equals(token, that.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token);
  }

  @Override
  public String toString() {
    return "FolderCreateParams{" + "token='[REDACTED]'" + '}';
  }
}
