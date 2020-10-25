package io.digitalready.accounts.user;

import io.digitalready.accounts.common.model.ApiResponse;
import io.digitalready.accounts.user.model.UserBodyDto;
import io.digitalready.accounts.user.model.UserRespDto;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

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
    public Mono<ApiResponse<UserRespDto>> getUser() {
        return userService.findCurrentUser()
                .map(userMapper::toDto)
                .map(ApiResponse::success);
    }

    @PostMapping
    public Mono<ApiResponse<UserRespDto>> postUser(@RequestBody UserBodyDto userDto) {
        return userService.createNewUser(userMapper.toEntity(userDto))
                .map(userMapper::toDto)
                .map(ApiResponse::success);
    }

}
