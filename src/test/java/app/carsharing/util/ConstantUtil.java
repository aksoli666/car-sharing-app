package app.carsharing.util;

import java.math.BigDecimal;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class ConstantUtil {
    public static final Long ID_1L_CORRECT = 1L;
    public static final Long ID_10L_CORRECT = 10L;
    public static final Long ID_11L_CORRECT = 11L;
    public static final Long ID_30L_CORRECT = 30L;
    public static final Long ID_41L_CORRECT = 41L;
    public static final Long ID_42L_CORRECT = 42L;
    public static final Long ID_43L_CORRECT = 43L;
    public static final Long ID_40L_CORRECT = 40L;
    public static final Long INCORRECT_ID = -100L;

    public static final BigDecimal PRICE_10 = BigDecimal.TEN;

    public static final int COUNT_CONTENT_1 = 1;
    public static final int COUNT_CONTENT_2 = 2;

    public static final String ROLE_CUSTOMER = "ROLE_CUSTOMER";
    public static final String STATUS_PENDING = "PENDING";

    public static final String TYPE_PAYMENT = "PAYMENT";

    public static final boolean IS_ACTIVE = true;
    public static final boolean NOT_ACTIVE = false;

    public static final Pageable pageable = PageRequest.of(0, 20);

    public static final String ADD_CARS_SQL =
            "classpath:database/carsharing/car/add-cars.sql";
    public static final String ADD_CAR_SQL =
            "classpath:database/carsharing/car/add-car.sql";
    public static final String UPDATE_CAR_SQL =
            "classpath:database/carsharing/car/update-car.sql";
    public static final String DELETE_UPD_CAR_SQL =
            "classpath:database/carsharing/car/delete-upd-car.sql";
    public static final String DELETE_RENTAL_CAR_SQL =
            "classpath:database/carsharing/car/delete-rental-car.sql";

    public static final String ADD_CAR_FOR_RENTAL_SQL =
            "classpath:database/carsharing/car/add-car-for-rental.sql";
    public static final String ADD_USER_FOR_RENTAL_SQL =
            "classpath:database/carsharing/user/add-user-for-rental.sql";
    public static final String ADD_RENTAL_FOR_SET_RETURN_SQL =
            "classpath:database/carsharing/rental/add-rental-for-set-return-date.sql";
    public static final String DELETE_UPD_RENTAL_SQL =
            "classpath:database/carsharing/rental/delete-upd-rental.sql";
    public static final String DELETE_USER_SQL =
            "classpath:database/carsharing/user/delete-user.sql";

    public static final String ADD_CAR_FOR_PAYMENT_SQL =
            "classpath:database/carsharing/car/add-car-for-payment.sql";
    public static final String ADD_USER_FOR_PAYMENT_SQL =
            "classpath:database/carsharing/user/add-user-for-payment.sql";
    public static final String ADD_RENTAL_FOR_PAYMENT_SQL =
            "classpath:database/carsharing/rental/add-rental-for-payment.sql";
    public static final String ADD_PAYMENT_SQL =
            "classpath:database/carsharing/payment/add-payment.sql";

    public static final String URL_CARS_WITHOUT_ID = "/cars";
    public static final String URL_CARS_WITH_ID = "/cars/{id}";

    public static final String URL_RENTALS_WITH_ID = "/rentals/{id}";

    public static final String URL_PAYMENTS_WITHOUT_ID = "/payments";
    public static final String URL_PAYMENTS_WITH_ID = "/payments/{id}";
}
