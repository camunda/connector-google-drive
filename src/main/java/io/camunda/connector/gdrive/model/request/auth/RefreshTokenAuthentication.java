/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.camunda.connector.gdrive.model.request.auth;

import com.google.api.client.util.Key;
import io.camunda.connector.api.SecretStore;
import io.camunda.connector.api.Validator;

import java.util.Objects;

public class RefreshTokenAuthentication extends Authentication {

  @Key private String clientId;
  @Key private String clientSecret;
  @Key private String refreshToken;

  @Override
  public void validateWith(Validator validator) {
    validator.require(clientId, "Authentication - Client Id");
    validator.require(clientSecret, "Authentication - Client secret");
    validator.require(refreshToken, "Authentication - Refresh Token");
  }

  @Override
  public void replaceSecrets(SecretStore secretStore) {
    clientId = secretStore.replaceSecret(clientId);
    clientSecret = secretStore.replaceSecret(clientSecret);
    refreshToken = secretStore.replaceSecret(refreshToken);
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    RefreshTokenAuthentication that = (RefreshTokenAuthentication) o;
    return clientId.equals(that.clientId) && clientSecret.equals(that.clientSecret) && refreshToken.equals(that.refreshToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), clientId, clientSecret, refreshToken);
  }

  @Override
  public String toString() {
    return "RefreshTokenAuthentication{" +
            "clientId='" + clientId + '\'' +
            ", clientSecret='" + clientSecret + '\'' +
            ", refreshToken='" + refreshToken + '\'' +
            '}';
  }
}
