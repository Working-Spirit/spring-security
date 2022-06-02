package nl.workingspirit.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CustomUser implements UserDetails {

    private final Long id;

    private final String username;
    private final String password;

    private final List<GrantedAuthority> authorities;

    public CustomUser(final Long id, final String username, final String password, final List<String> authorities) {
        this.id = id;

        this.username = username;
        this.password = password;

        this.authorities = authorities
            .stream()
            .map(SimpleGrantedAuthority::new)
            .collect(toList());
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
