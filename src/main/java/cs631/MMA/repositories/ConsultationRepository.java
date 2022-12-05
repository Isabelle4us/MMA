package cs631.MMA.repositories;

import cs631.MMA.entities.Consultation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ConsultationRepository extends CrudRepository<Consultation, Integer> {
    @Query("select c from Consultation c where c.patient.id=?1 and c.physician.id=?2 and c.date=?3")
    List<Consultation> getAppointments(Integer id, Integer physicianId, LocalDate date);

}
