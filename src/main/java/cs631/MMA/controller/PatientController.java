package cs631.MMA.controller;

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
        patientRepository.deletePatientByNo(patient.getPatientNo());
        return "Patient Deleted";
    }

    @GetMapping("/{id}")
    public @ResponseBody Patient getPatient (@PathVariable Long id) {
        return patientRepository.getPatientByNo(id);
    }
}
