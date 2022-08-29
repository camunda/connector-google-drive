package io.camunda.connector.gdrive.model.request.auth;

import com.google.api.client.util.Value;

public enum AuthenticationType {

    @Value("bearer")
    BEARER,
    @Value("refresh")
    REFRESH
}
