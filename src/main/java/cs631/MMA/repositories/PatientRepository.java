package cs631.MMA.repositories;

import cs631.MMA.entities.Patient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Patient p where p.patientNo=?1")
    void deletePatientById(Long patientId);

    @Query("select p from Patient p where p.patientNo=?1")
    Patient getPatientById(Long patientId);
}