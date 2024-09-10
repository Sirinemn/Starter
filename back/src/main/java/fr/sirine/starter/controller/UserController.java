package fr.sirine.starter.controller;

import fr.sirine.starter.dto.UserDto;
import fr.sirine.starter.mapper.UserMapper;
import fr.sirine.starter.user.User;
import fr.sirine.starter.user.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/user")
@Tag(name="User")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper)
    {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable String id) throws IOException {

        User user = userService.findById(Integer.parseInt(id));

        return ResponseEntity.ok(userMapper.toDto(user));
    }


}
