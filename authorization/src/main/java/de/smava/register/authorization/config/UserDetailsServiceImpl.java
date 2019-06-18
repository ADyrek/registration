package de.smava.register.authorization.config;

import de.smava.register.authorization.domain.common.dto.UserDto;
import de.smava.register.authorization.integration.OrchestratorClient;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final OrchestratorClient orchestratorClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        orchestratorClient.findUser(email);

        UserDto user = orchestratorClient.findUser(email);

        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        return new User(user.getEmail(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
