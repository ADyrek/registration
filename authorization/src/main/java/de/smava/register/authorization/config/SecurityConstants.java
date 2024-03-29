package de.smava.register.authorization.config;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SecurityConstants {
    public static final String ROLE_USER = "ROLE_USER";
    static final String SIGNING_KEY = "e55a8g5GAocFSfqP7gzbAMlyukZzrQn3e1KRQQbKw6XGWUnMEWZYSwC9yDjZgQt";
    static final String RESOURCE_ID = "webapp";
    static final String CLIENT_ID = "client";
    static final String CLIENT_SECRET = "$2a$10$HlzMvb9OQayvlWfX5pzJTeZvH30eKwnc6gE0C3idjDvbQt4XJMTki";// secret
    static final String GRANT_TYPE_PASSWORD = "password";
    static final String AUTHORIZATION_CODE = "authorization_code";
    static final String REFRESH_TOKEN = "refresh_token";
    static final String IMPLICIT = "implicit";
    static final int ACCESS_TOKEN_VALIDITY_SECONDS = 3600;
    static final int REFRESH_TOKEN_VALIDITY_SECONDS = 6 * ACCESS_TOKEN_VALIDITY_SECONDS;
    static final String SCOPE_READ = "read";
    static final String SCOPE_WRITE = "write";
    static final String OAUTH2_HAS_SCOPE_READ = "#oauth2.hasScope('" + SCOPE_READ + "')";
    static final String OAUTH2_HAS_SCOPE_WRITE = "#oauth2.hasScope('" + SCOPE_WRITE + "')";
}
