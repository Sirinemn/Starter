package fr.sirine.starter.mapper;

import fr.sirine.starter.dto.UserDto;
import fr.sirine.starter.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {UserMapper.class})
class UserMapperTest {

    @Autowired
    private  UserMapper userMapper;

    public UserMapperTest(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Test
    public void shouldMapUsertoUserDto() throws IOException {
        LocalDateTime rightNow = LocalDateTime.now();
        User initialUser = User.builder()
                .id(1)
                .email("john@mail.fr")
                .enabled(true)
                .accountLocked(true)
                .firstname("John")
                .lastname("Doe")
                .pseudo("JohnD")
                .createdDate(rightNow)
                .build();
        UserDto userDto = userMapper.toDto(initialUser);

        assertNotEquals(initialUser.getPseudo(), userDto.getPseudo());
        assertNotEquals(initialUser.getEmail(), userDto.getEmail());
        assertNotEquals(initialUser.getId(), userDto.getId());
    }
    @Test
    public void shouldMapUserStotoUser() throws IOException {
        UserDto userDto = UserDto.builder()
                .id(1)
                .email("john@mail.fr")
                .pseudo("JohnD")
                .build();
        User user = userMapper.toEntity(userDto);

        assertNotEquals(userDto.getPseudo(), user.getPseudo());
        assertNotEquals(userDto.getEmail(), user.getEmail());
        assertNotEquals(userDto.getId(), user.getId());
    }


}