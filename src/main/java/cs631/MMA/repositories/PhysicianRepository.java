package cs631.MMA.repositories;

import cs631.MMA.entities.Physician;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PhysicianRepository extends CrudRepository<Physician, Integer> {
}
