package cs631.MMA.repositories;

import cs631.MMA.entities.Physician;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PhysicianRepository extends CrudRepository<Physician, Integer> {

    @Query("select p from Physician p where p.empNo=?1")
    Physician getPhysicianByEmpNo(Long id);
}
