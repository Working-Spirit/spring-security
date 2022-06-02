package nl.workingspirit.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;
import java.util.stream.Collectors;

public class CustomClient implements ClientDetails {

    private final String clientId;
    private final String clientSecret;

    private final List<GrantedAuthority> authorities;

    private final Map<String, Object> additionalInfo;

    public CustomClient(
        final String clientId,
        final String clientSecret,
        final List<String> authorities
    ) {
        this(clientId, clientSecret, authorities, new HashMap<>());
    }

    public CustomClient(
        final String clientId,
        final String clientSecret,
        final List<String> authorities,
        final Map<String, Object> additionalInfo
    ) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;

        this.authorities = authorities
            .stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

        this.additionalInfo = additionalInfo;
    }

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return this.clientSecret;
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        final Set<String> scopes = new HashSet<>();

        scopes.add("API");

        return scopes;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        final Set<String> authorizedGrantTypes = new HashSet<>();

        authorizedGrantTypes.add("password");

        return authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return Collections.emptySet();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return 60 * 60 * 4;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return 60 * 60 * 24 * 7;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return this.additionalInfo;
    }

}
