package io.digitalready.accounts.user;

import io.digitalready.accounts.common.model.ApiResponse;
import io.digitalready.accounts.common.model.ApiSuccessResponse;
import io.digitalready.accounts.user.model.UserBodyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.security.Principal;

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
    public Mono<ApiResponse> getUser(Principal user) {
        return userService.findUserByUsername(user.getName())
                .map(userMapper::toDto)
                .map(ApiSuccessResponse::of);
    }

    @PostMapping
    public Mono<ApiResponse> postUser(@RequestBody UserBodyDto userDto) {
        return userService.createNewUser(userMapper.toEntity(userDto))
                .map(userMapper::toDto)
                .map(ApiSuccessResponse::of);
    }

}
