package me.cocoding.openapi.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String apiToken) throws UsernameNotFoundException {
        String[] tokenPair = apiToken.split(",");

        if (tokenPair.length != 2) {
            throw new RuntimeException("잘못된 인증 정보입니다");
        }

        // [0] clientId
        // [1] clientSecret

        User user = userRepository.findUserByClientIdAndClientSecret(tokenPair[0], tokenPair[1]).orElseThrow(
                () -> new UsernameNotFoundException("잘못된 인증 정보입니다")
        );

        return CustomUserDetails.create(user);
    }
}
