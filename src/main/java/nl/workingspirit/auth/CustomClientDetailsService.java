package nl.workingspirit.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

@Service
public class CustomClientDetailsService implements ClientDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomClientDetailsService(
        @Lazy final PasswordEncoder passwordEncoder
    ) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        final CustomClient customClient = new CustomClient(
            clientId,
            this.passwordEncoder.encode("secret"),
            asList(
                "System"
            )
        );

        return customClient;
    }

}
