package app.carsharing.repository;

import static app.carsharing.util.ConstantUtil.COUNT_CONTENT_1;
import static app.carsharing.util.ConstantUtil.ID_42L_CORRECT;
import static app.carsharing.util.ConstantUtil.ID_43L_CORRECT;
import static app.carsharing.util.ConstantUtil.pageable;
import static app.carsharing.util.EntityAndDtoMaker.createCar1L;
import static app.carsharing.util.EntityAndDtoMaker.createRental;
import static app.carsharing.util.EntityAndDtoMaker.createUser1L;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import app.carsharing.model.Car;
import app.carsharing.model.Rental;
import app.carsharing.model.User;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RentalRepositoryTest {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RentalRepository rentalRepository;

    @Test
    @DisplayName("""
            Verify #findByUserIdAndActualReturnDateIsNull, return Page<Rental>
            """)
    void findByUserIdAndActualReturnDateIsNull_correctId_returnPageRental() {
        Car car = carRepository.save(createCar1L());
        User user = userRepository.save(createUser1L());
        Rental rental = createRental();
        rental.setActualReturnDate(null);
        rental.setUser(user);
        rental.setCar(car);
        rentalRepository.save(rental);

        Page<Rental> rentals = rentalRepository
                .findByUserIdAndActualReturnDateIsNull(user.getId(), pageable);

        assertNotNull(rentals);
        assertEquals(COUNT_CONTENT_1, rentals.getTotalElements());
        assertEquals(ID_42L_CORRECT, rentals.getContent().get(0).getId());
    }

    @Test
    @DisplayName("""
            Verify #findByUserIdAndActualReturnDateIsNotNull, return Page<Rental>
            """)
    void findByUserIdAndActualReturnDateIsNotNull_correctId_returnPageRental() {
        Car car = carRepository.save(createCar1L());
        User user = userRepository.save(createUser1L());
        Rental rental = createRental();
        rental.setUser(user);
        rental.setCar(car);
        rentalRepository.save(rental);

        Page<Rental> rentals = rentalRepository
                .findByUserIdAndActualReturnDateIsNotNull(user.getId(), pageable);

        assertNotNull(rentals);
        assertEquals(COUNT_CONTENT_1, rentals.getTotalElements());
        assertEquals(ID_43L_CORRECT, rentals.getContent().get(0).getId());
    }

    @Test
    @DisplayName("""
            Verify #findByIdAndUserId, return Rental
            """)
    void findByIdAndUserId_correctId_returnRental() {
        Car car = carRepository.save(createCar1L());
        User user = userRepository.save(createUser1L());
        Rental expected = createRental();
        expected.setUser(user);
        expected.setCar(car);
        rentalRepository.save(expected);

        Optional<Rental> actual = rentalRepository
                .findByIdAndUserId(expected.getId(), user.getId());

        assertNotNull(actual);
        assertEquals(expected, actual.get());
    }
}
