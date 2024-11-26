package app.carsharing.repository;

import app.carsharing.model.Rental;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    Page<Rental> findByUserIdAndActualReturnDateIsNull(Long userId,
                                                          Pageable pageable);

    Page<Rental> findByUserIdAndActualReturnDateIsNotNull(Long userId,
                                                          Pageable pageable);

    Optional<Rental> findByIdAndUserId(Long id, Long userId);

    List<Rental> findByReturnDateBeforeAndActualReturnDateIsNull(LocalDate date);

    List<Rental> findByReturnDateAfterOrActualReturnDateIsNotNull(LocalDate date);
}
