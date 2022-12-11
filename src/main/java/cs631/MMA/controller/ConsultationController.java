package cs631.MMA.controller;

import cs631.MMA.entities.Consultation;
import cs631.MMA.entities.Illness;
import cs631.MMA.entities.Patient;
import cs631.MMA.entities.Physician;
import cs631.MMA.models.ConsultationDTO;
import cs631.MMA.repositories.ConsultationRepository;
import cs631.MMA.repositories.IllnessRepository;
import cs631.MMA.repositories.PatientRepository;
import cs631.MMA.repositories.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/consultation")
public class ConsultationController {
    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private PhysicianRepository physicianRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private IllnessRepository illnessRepository;

    @PostMapping
    public @ResponseBody String addConsultation (@RequestBody ConsultationDTO consultationDTO) {
        Physician physician = physicianRepository.findById(consultationDTO.getPhysicianId())
                .orElseThrow(() -> new IllegalArgumentException("No physician found"));

        Patient patient = patientRepository.findById(consultationDTO.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("No patient found"));

        Illness illness = illnessRepository.findById(consultationDTO.getIllnessId())
                .orElseThrow(() -> new IllegalArgumentException("No illness found"));

        Consultation consultation = consultationDTO.toConsultation();
        consultation.setPhysician(physician);
        consultation.setPatient(patient);
        consultation.setIllness(illness);

        Consultation savedConsultation = consultationRepository.save(consultation);

        physician.getConsultations().add(consultation);
        patient.getConsultations().add(consultation);
        return savedConsultation.getId().toString();
    }
}
