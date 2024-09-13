package fr.sirine.starter.auth;

import fr.sirine.starter.security.JwtService;
import fr.sirine.starter.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    public  AuthenticationService authenticationService;

    @MockBean
    public  UserService userService;

    @MockBean
    private JwtService jwtService;

    @Test
    public void shouldRegisterSuccessfully() throws Exception {

        // Create a mock request payload
        String registrationRequestJson = "{ \"firstname\": \"John\", \"lastname\": \"Doe\", \"pseudo\": \"john_doe\", \"dateOfBirth\":\"LocalDateTime.of(2000, 1, 1, 10, 10, 0)\", \"email\": \"test@example.com\" , \"password\": \"password\" }";

        // Call the register method via MockMvc
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(registrationRequestJson))
                .andExpect(status().isAccepted());

        // Verify if the service method was called
        verify(authenticationService, times(1)).register(any(RegistrationRequest.class));
    }

}