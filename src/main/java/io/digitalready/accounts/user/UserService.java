package io.digitalready.accounts.user;

import io.digitalready.accounts.common.exception.AuthenticationNotFoundException;
import io.digitalready.accounts.common.exception.UserRegisteredException;
import io.digitalready.accounts.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Mono<User> findUserByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    public Mono<User> findCurrentUser() {
        return findUserCurrentAuthenticated()
                .flatMap(u -> userRepository.findByEmail(u.getEmail()));
    }

    public Mono<User> createNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.findByEmail(user.getEmail())
                .flatMap(e -> Mono.error(new UserRegisteredException(e.getEmail())))
                .switchIfEmpty(userRepository.save(user))
                .cast(User.class);
    }

    public Mono<User> findUserCurrentAuthenticated() {
        return ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .switchIfEmpty(Mono.error(new AuthenticationNotFoundException()))
                .map(Authentication::getName)
                .flatMap(this::findUserByUsername);
    }

}
