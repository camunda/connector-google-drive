package io.camunda.connector.gdrive.model.request.auth;

import io.camunda.connector.api.SecretStore;
import io.camunda.connector.api.Validator;

import java.util.Objects;

public abstract class Authentication {

    private transient String type;

    public abstract void validateWith(Validator validator);

    public abstract void replaceSecrets(SecretStore secretStore);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authentication that = (Authentication) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Authentication{" +
                "type='" + type + '\'' +
                '}';
    }
}
