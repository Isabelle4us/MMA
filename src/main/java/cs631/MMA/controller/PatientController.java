package cs631.MMA.controller;

import cs631.MMA.entities.Clinic;
import cs631.MMA.entities.Patient;
import cs631.MMA.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public @ResponseBody String addPatient (@RequestBody Patient patient) {
        patientRepository.save(patient);
        return "Patient Added";
    }

    @DeleteMapping
    public @ResponseBody String deletePatient (@RequestBody Patient patient) {
        patientRepository.deletePatientById(patient.getPatientNo());
        return "Patient Deleted";
    }

    @GetMapping
    public @ResponseBody Patient getPatient (@RequestBody Patient patient) {
        return patientRepository.getPatientById(patient.getPatientNo());

    }
}
