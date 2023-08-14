package Repositories;

import entities.Plate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlateRepository extends JpaRepository<Plate, Long> {

}
