package app.carsharing.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private String model;
    private String brand;
    private String type;
    private int inventory;
    private BigDecimal daileFee;
}
