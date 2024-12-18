package app.carsharing.controller;

import app.carsharing.dto.UserDto;
import app.carsharing.dto.request.UserLoginRequestDto;
import app.carsharing.dto.request.UserRegisterRequestDto;
import app.carsharing.dto.responce.UserLoginResponseDto;
import app.carsharing.exception.RegistrationException;
import app.carsharing.security.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication", description = "Endpoints for managing users authentication")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Operation(
            summary = "Register a new user",
            description = "Registers a new user by providing essential details "
                    + "such as email, password, first name, and last name. "
                    + "Upon successful registration, "
                    + "the user will be able to log in and access the system."
    )
    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto register(@Valid @RequestBody UserRegisterRequestDto registerDto)
            throws RegistrationException {
        return authenticationService.register(registerDto);
    }

    @Operation(
            summary = "Log in a user",
            description = "Authenticates the user using email and password, "
                    + "and returns a JWT token that can be used for subsequent API requests. "
                    + "The token grants access to protected resources in the application."
    )
    @PostMapping("/login")
    public UserLoginResponseDto login(@Valid @RequestBody UserLoginRequestDto loginDto) {
        return authenticationService.login(loginDto);
    }
}
