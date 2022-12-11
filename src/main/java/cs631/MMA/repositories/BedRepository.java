package cs631.MMA.repositories;

import cs631.MMA.entities.Bed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BedRepository extends CrudRepository<Bed, Integer> {

    @Query("select b from Bed b where b.available=true")
    List<Bed> findAllAvailableBeds();
}
