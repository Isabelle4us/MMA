package cs631.MMA.repositories;

import cs631.MMA.entities.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface OperationRepository extends CrudRepository<Operation, Integer> {
    @Query("select o from Operation o where o.surgeon.id=?1 and o.date=?2 and o.finished=false")
    List<Operation> getOperationsByDate(Integer id, LocalDate date);

    @Query("select o from Operation o where o.surgeon.id=?1 and o.date=?2 and o.location=?3 and o.finished=false")
    List<Operation> getOperationsByLocation(Integer id, LocalDate date, String Location);
}
