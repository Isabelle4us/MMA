package cs631.MMA.repositories;

import cs631.MMA.entities.Illness;
import org.springframework.data.repository.CrudRepository;

public interface IllnessRepository extends CrudRepository<Illness, Integer> {

}
