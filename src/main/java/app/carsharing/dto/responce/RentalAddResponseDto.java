package app.carsharing.dto.responce;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalAddResponseDto {
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private Long carId;
}
