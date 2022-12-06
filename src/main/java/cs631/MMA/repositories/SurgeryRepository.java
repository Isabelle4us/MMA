package cs631.MMA.repositories;

import cs631.MMA.entities.Surgery;
import org.springframework.data.repository.CrudRepository;

public interface SurgeryRepository extends CrudRepository<Surgery, Integer> {
}
