package cs631.MMA.repositories;

import cs631.MMA.entities.Nurse;
import org.springframework.data.repository.CrudRepository;

public interface NurseRepository extends CrudRepository<Nurse, Integer> {
}
