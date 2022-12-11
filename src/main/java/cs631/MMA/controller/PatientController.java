package cs631.MMA.controller;

import cs631.MMA.entities.Consultation;
import cs631.MMA.entities.Operation;
import cs631.MMA.entities.Patient;
import cs631.MMA.models.ConsultationDTO;
import cs631.MMA.models.OperationDTO;
import cs631.MMA.models.PatientDTO;
import cs631.MMA.repositories.ConsultationRepository;
import cs631.MMA.repositories.OperationRepository;
import cs631.MMA.repositories.PatientRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private OperationRepository operationRepository;

    //create patient
    @PostMapping
    public @ResponseBody Integer addPatient (@RequestBody PatientDTO patientDTO) {
        Patient patient = patientDTO.toPatient();
        Patient saved = patientRepository.save(patient);
        return saved.getId();
    }

    //update patient
    @PutMapping
    public @ResponseBody String updatePatient (@RequestBody PatientDTO patientDTO) {
        if (patientDTO.getId() == null) {
            throw new IllegalArgumentException("No patient id provided");
        }
        Patient patient = getPatientById(patientDTO.getId());
        updatePatientByDTO(patient, patientDTO);
        patientRepository.save(patient);
        return "Patient updated";
    }
    private void updatePatientByDTO(Patient patient, PatientDTO patientDTO) {
        patient.setPatientNo(patientDTO.getPatientNo());
        patient.setGender(patientDTO.getGender());
        patient.setBirthday(patientDTO.getBirthday());
        patient.setHDL(patientDTO.getHDL());
        patient.setName(patientDTO.getName());
        patient.setLDL(patientDTO.getLDL());
        patient.setSSN(patientDTO.getSSN());
        patient.setTel(patientDTO.getTel());
        patient.setBloodSugar(patientDTO.getBloodSugar());
        patient.setBloodType(patientDTO.getBloodType());
        patient.setTriglyceride(patientDTO.getTriglyceride());
    }

    //delete patient
    @DeleteMapping("/{id}")
    public @ResponseBody String deletePatient (@PathVariable Integer id) {
        patientRepository.deleteById(id);
        return "Patient Deleted";
    }

    //get patient
    @GetMapping("/{id}")
    public @ResponseBody PatientDTO getPatient (@PathVariable Integer id) {
        return getPatientById(id).toDTO();
    }

    private Patient getPatientById (Integer id) {
        return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No patient found"));
    }

    @GetMapping
    public @ResponseBody List<PatientDTO> getAllPatients () {
        List<PatientDTO> allPatients = new ArrayList<>();
        patientRepository.findAll().forEach(patient -> allPatients.add(patient.toDTO()));
        return allPatients;
    }

    //get all past consultations
    @GetMapping("/{id}/consultation")
    public @ResponseBody List<ConsultationDTO> getConsultations(@PathVariable Integer id) {
        return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No patient found"))
                .getConsultations()
                .stream()
                .filter(consultation -> consultation.getDiagnosed() != null)
                .map(Consultation::toDTO)
                .collect(Collectors.toList());
    }

    //get all diagnosed illnesses
    @GetMapping("/{id}/illness")
    public @ResponseBody List<ConsultationDTO> getIllnesses(@PathVariable Integer id) {
        return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No patient found"))
                .getConsultations()
                .stream()
                .filter(consultation -> consultation.getDiagnosed() != null && consultation.getDiagnosed())
                .map(Consultation::toDTO)
                .collect(Collectors.toList());
    }

    //get appointments given a doctor and a day
    @PostMapping("/{id}/appointment")
    public @ResponseBody List<ConsultationDTO> getAppointments(@PathVariable Integer id, @RequestBody ConsultationDTO request) {
            return consultationRepository.getAppointments(id, request.getPhysicianId(), request.getDate())
                    .stream()
                    .map(Consultation::toDTO)
                    .collect(Collectors.toList());
    }

    //get all operations
    @PostMapping("/{id}/operation")
    public @ResponseBody List<OperationDTO> getOperations(@PathVariable Integer id, @RequestBody OperationDTO request) {
        if (StringUtils.isNotBlank(request.getLocation())) {
            return operationRepository.getOperationsByLocation(request.getSurgeonId(), request.getDate(), request.getLocation())
                    .stream()
                    .map(Operation::toDTO)
                    .collect(Collectors.toList());
        } else if (request.getDate() != null) {
            return operationRepository.getOperationsByDate(request.getSurgeonId(), request.getDate())
                    .stream()
                    .map(Operation::toDTO)
                    .collect(Collectors.toList());
        } else {
            return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("patientId not found"))
                    .getOperations().stream().map(Operation::toDTO).collect(Collectors.toList());
        }
    }
}