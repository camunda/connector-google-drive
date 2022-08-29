package io.camunda.connector.gdrive.model.request.auth;

import com.google.api.client.util.Key;

public class RefreshTokenAuthentication {

    @Key private String clientId;
    @Key private String clientSecret;
    @Key private String refreshToken;
}
