package io.camunda.connector.dgrive.model;

import java.util.Objects;

public class FolderCreateParams {
  private String name;
  private String parent;
  private String additionalProperties;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public String getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(String additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FolderCreateParams that = (FolderCreateParams) o;
    return name.equals(that.name)
        && Objects.equals(parent, that.parent)
        && Objects.equals(additionalProperties, that.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, parent, additionalProperties);
  }

  @Override
  public String toString() {
    return "FolderCreateParams{"
        + "name='"
        + name
        + '\''
        + ", parent='"
        + parent
        + '\''
        + ", additionalProperties='"
        + additionalProperties
        + '\''
        + '}';
  }
}
