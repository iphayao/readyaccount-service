package io.digitalready.accounts.user;

import io.digitalready.accounts.common.exception.UserRegisteredException;
import io.digitalready.accounts.user.model.User;
import lombok.extern.slf4j.Slf4j;
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


    public Mono<User> createNewUser(User user) {
        log.info("Create New User of '{}'", user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.findByEmail(user.getEmail())
                .flatMap(e -> Mono.error(new UserRegisteredException(e.getEmail())))
                .switchIfEmpty(userRepository.save(user))
                .cast(User.class);
    }

    public Mono<User> findUserByUsername(String username) {
        log.info("Get User Info of '{}'", username);
        return userRepository.findByEmail(username);
    }
}
