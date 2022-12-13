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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
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

    DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    @PostMapping
    public @ResponseBody String addConsultation (@RequestBody ConsultationDTO consultationDTO) throws ParseException {
        Physician physician = physicianRepository.findById(consultationDTO.getPhysicianId())
                .orElseThrow(() -> new IllegalArgumentException("No physician found"));

        Patient patient = patientRepository.findById(consultationDTO.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("No patient found"));

        Illness illness = illnessRepository.findById(consultationDTO.getIllnessId())
                .orElseThrow(() -> new IllegalArgumentException("No illness found"));

        Consultation consultation = consultationDTO.toConsultation();
        Date startDate = consultation.getStartDate();
        Date dateOnly = formatter.parse(formatter.format(startDate));
        consultation.setDate(dateOnly);

        consultation.setPhysician(physician);
        consultation.setPatient(patient);
        consultation.setIllness(illness);

        Consultation savedConsultation = consultationRepository.save(consultation);

        physician.getConsultations().add(consultation);
        patient.getConsultations().add(consultation);
        return savedConsultation.getId().toString();
    }

    @GetMapping
    public List<ConsultationDTO> getConsultations() {
        List<ConsultationDTO> list = new ArrayList<>();
        consultationRepository.findAll().forEach(consultation -> list.add(consultation.toDTO()));
        return list;
    }

    @GetMapping("/{id}")
    public ConsultationDTO getConsultationById(@PathVariable Integer id) {
        return consultationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no consultation id found"))
                .toDTO();
    }
}