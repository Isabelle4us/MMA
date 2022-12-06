package cs631.MMA.repositories;

import cs631.MMA.entities.Bed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BedRepository extends CrudRepository<Bed, Integer> {

    @Query("select b from Bed b where b.available=true")
    Iterable<Bed> findAllAvailableBeds();
}
