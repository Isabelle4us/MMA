package cs631.MMA.controller;

import cs631.MMA.entities.Consultation;
import cs631.MMA.entities.Patient;
import cs631.MMA.models.AppointmentRequest;
import cs631.MMA.repositories.ConsultationRepository;
import cs631.MMA.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @PostMapping
    public @ResponseBody String addPatient (@RequestBody Patient patient) {
        patientRepository.save(patient);
        return "Patient Added";
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String deletePatient (@PathVariable Integer id) {
        patientRepository.deleteById(id);
        return "Patient Deleted";
    }

    @GetMapping("/{id}")
    public @ResponseBody Patient getPatient (@PathVariable Integer id) {
        return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No patient found"));
    }

    @GetMapping("/{id}/consultation")
    public @ResponseBody List<Consultation> getConsultations(@PathVariable Integer id) {
        return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No patient found"))
                .getConsultations()
                .stream()
                .filter(consultation -> consultation.getDiagnosed() != null)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/illness")
    public @ResponseBody List<Consultation> getIllnesses(@PathVariable Integer id) {
        return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No patient found"))
                .getConsultations()
                .stream()
                .filter(consultation -> consultation.getDiagnosed() != null && consultation.getDiagnosed())
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}/schedule")
    public @ResponseBody List<Consultation> getAppointments(@PathVariable Integer id, @RequestBody AppointmentRequest request) {
        return consultationRepository.getAppointments(id, request.getPhysicianId(), request.getDate());
    }
}
