package app.carsharing.repository;

import static app.carsharing.util.ConstantUtil.COUNT_CONTENT_1;
import static app.carsharing.util.ConstantUtil.ID_41L_CORRECT;
import static app.carsharing.util.ConstantUtil.pageable;
import static app.carsharing.util.EntityAndDtoMaker.createCar1L;
import static app.carsharing.util.EntityAndDtoMaker.createPayment;
import static app.carsharing.util.EntityAndDtoMaker.createRental;
import static app.carsharing.util.EntityAndDtoMaker.createUser1L;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import app.carsharing.model.Car;
import app.carsharing.model.Payment;
import app.carsharing.model.Rental;
import app.carsharing.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PaymentRepositoryTest {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    @DisplayName("""
            Verify #findByRentalUserIdFetchRental(), return Page<Book>
            """)
    void findByRentalUserIdFetchRental_correctId_returnPageBook() {
        Car car = carRepository.save(createCar1L());
        User user = userRepository.save(createUser1L());
        Rental rental = createRental();
        rental.setUser(user);
        rental.setCar(car);
        rentalRepository.save(rental);
        Payment payment = createPayment();
        payment.setRental(rental);
        paymentRepository.save(payment);

        Page<Payment> payments = paymentRepository.findByRentalUserIdFetchRental(
                user.getId(), pageable);

        assertNotNull(payments);
        assertEquals(COUNT_CONTENT_1, payments.getTotalElements());
        assertEquals(ID_41L_CORRECT, payments.getContent().get(0).getId());
    }
}
