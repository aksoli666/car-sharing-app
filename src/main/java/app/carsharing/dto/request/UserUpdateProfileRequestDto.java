package app.carsharing.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateProfileRequestDto {
    private String firstName;
    private String lastName;
}
