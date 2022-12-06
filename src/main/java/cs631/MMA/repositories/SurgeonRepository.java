package cs631.MMA.repositories;

import cs631.MMA.entities.Operation;
import cs631.MMA.entities.Surgeon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface SurgeonRepository extends CrudRepository<Surgeon, Integer> {

}
