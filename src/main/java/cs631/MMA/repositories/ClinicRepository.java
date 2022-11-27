package cs631.MMA.repositories;

import cs631.MMA.entities.Clinic;
import org.springframework.data.repository.CrudRepository;

public interface ClinicRepository extends CrudRepository<Clinic, Integer> {
}
