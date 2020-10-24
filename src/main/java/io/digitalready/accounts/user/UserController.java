package io.digitalready.accounts.user;

import io.digitalready.accounts.common.model.ApiResponse;
import io.digitalready.accounts.common.model.ApiSuccessResponse;
import io.digitalready.accounts.user.model.UserBodyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public Mono<ApiResponse> getUser() {
        return userService.findCurrentUser()
                .doOnSuccess(u -> log.info("Get info of user id: {}, username: {}", u.getId(), u.getEmail()))
                .map(userMapper::toDto)
                .map(ApiSuccessResponse::of);
    }

    @PostMapping
    public Mono<ApiResponse> postUser(@RequestBody UserBodyDto userDto) {
        return userService.createNewUser(userMapper.toEntity(userDto))
                .doOnSuccess(u -> log.info("Create user id: {}, username: {}", u.getId(), u.getEmail()))
                .map(userMapper::toDto)
                .map(ApiSuccessResponse::of);
    }

}
