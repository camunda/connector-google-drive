package io.camunda.connector.dgrive.model;

import io.camunda.connector.api.SecretStore;
import io.camunda.connector.api.Validator;
import java.util.Objects;

public class GoogleDriveRequest {

  private AuthenticationParam authentication;
  private FolderCreateParams folder;

  public void validateWith(final Validator validator) {
    // TODO: Make proper validation
    validator.require(authentication, "Authentication - Missing");
    if (authentication != null) {
      validator.require(authentication.getToken(), "Authentication Token - Missing");
    }
    validator.require(folder, "Folder creation params - Missing");
    if (folder != null) {}
  }

  public void replaceSecrets(final SecretStore secretStore) {
    authentication.setToken(secretStore.replaceSecret(authentication.getToken()));
  }

  public AuthenticationParam getAuthentication() {
    return authentication;
  }

  public void setAuthentication(AuthenticationParam authentication) {
    this.authentication = authentication;
  }

  public FolderCreateParams getFolder() {
    return folder;
  }

  public void setFolder(FolderCreateParams folder) {
    this.folder = folder;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GoogleDriveRequest that = (GoogleDriveRequest) o;
    return authentication.equals(that.authentication) && folder.equals(that.folder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authentication, folder);
  }

  @Override
  public String toString() {
    return "GoogleDriveRequest{" + "authentication=" + authentication + ", folder=" + folder + '}';
  }
}
