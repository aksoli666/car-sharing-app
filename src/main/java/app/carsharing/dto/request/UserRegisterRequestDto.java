package app.carsharing.dto.request;

import app.carsharing.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@FieldMatch(
        firstFieldName = "password",
        secondFieldName = "repeatPassword",
        message = "Password must match!"
)
@Getter
@Setter
public class UserRegisterRequestDto {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String password;
    @NotBlank
    private String repeatPassword;
    @NotBlank
    private String telegramChatId;
}
