package app.carsharing.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDto {
    private String status;
    private String type;
    private Long rentalId;
    private BigDecimal amount;
}
