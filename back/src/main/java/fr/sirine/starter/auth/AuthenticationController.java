package fr.sirine.ma_cuisine_maison.auth;


import fr.sirine.ma_cuisine_maison.user.User;
import fr.sirine.ma_cuisine_maison.user.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name="Authentication")
public class AuthenticationController {

    public final AuthenticationService authenticationService;
    public final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody @Valid RegistrationRequest request
    ) throws MessagingException, Exception {
        authenticationService.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authenticate(
        @RequestBody @Valid AuthenticationRequest request
    ){
        return  ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/activate-account")
    public void confirm(
            @RequestParam String token
    ) throws Exception {
        authenticationService.activateAccount(token);
    }

    @GetMapping("/me")
    public ResponseEntity<User> currentUserName(Authentication authentication)  {
        String name = authentication.getName();
        User user = userService.findByEmail(name);

            return ResponseEntity.ok(user);

    }
}
