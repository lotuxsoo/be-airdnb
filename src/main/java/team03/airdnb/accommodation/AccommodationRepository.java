package team03.airdnb.accommodation;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long>, AccommodationRepositoryCustom {

    @Modifying
    @Transactional
    @Query("UPDATE Accommodation a SET a.averageGrade = :averageGrade WHERE a.id = :id")
    int updateAverageGrade(@Param("id") Long id, @Param("averageGrade") double averageGrade);

    List<Accommodation> findAccommodationsByFilters(LocalDate checkIn, LocalDate checkOut, Double minPrice, Double maxPrice, Integer capacity);
}
