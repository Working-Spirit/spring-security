package nl.workingspirit.auth;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;

import java.util.Map;

public class CustomTokenConverter extends DefaultAccessTokenConverter {

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
        OAuth2Authentication auth2Authentication = super.extractAuthentication(claims);

        auth2Authentication.setDetails(claims);

        return auth2Authentication;
    }
}
