package cs631.MMA.repositories;

import cs631.MMA.entities.Consultation;
import cs631.MMA.entities.Patient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Patient p where p.patientNo=?1")
    void deletePatientByNo(Long patientNo);

    @Query("select p from Patient p where p.patientNo=?1")
    Patient getPatientByNo(Long patientNo);
}