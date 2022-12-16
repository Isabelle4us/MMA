package cs631.MMA.controller;

import cs631.MMA.entities.*;
import cs631.MMA.models.InpatientDTO;
import cs631.MMA.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/inpatient")
public class InpatientController {
    @Autowired
    private InpatientRepository inpatientRepository;
    @Autowired
    private BedRepository bedRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private PhysicianRepository physicianRepository;

    @PostMapping
    public @ResponseBody Integer addInpatientToBed(@RequestBody InpatientDTO inpatientDTO) {
        Bed bed = bedRepository.findById(inpatientDTO.getBedId()).orElseThrow(() -> new IllegalArgumentException("bedId not found"));
        Patient patient = patientRepository.findById(inpatientDTO.getPatientId()).orElseThrow(() -> new IllegalArgumentException("patientId not found"));
        Nurse nurse = nurseRepository.findById(inpatientDTO.getNurseId()).orElseThrow(() -> new IllegalArgumentException("patientId not found"));
        Physician physician = physicianRepository.findById(inpatientDTO.getPhysicianId()).orElseThrow(() -> new IllegalArgumentException("physicianId not found"));

        bed.setAvailable(false);
        bedRepository.save(bed);
        Inpatient inpatient = inpatientDTO.toInpatient();
        inpatient.setBed(bed);
        inpatient.setPatient(patient);
        inpatient.setNurse(nurse);
        inpatient.setPhysician(physician);

        Inpatient saved = inpatientRepository.save(inpatient);
        return saved.getId();
    }

    @GetMapping
    public @ResponseBody List<InpatientDTO> getInpatients() {
        List<InpatientDTO> list = new ArrayList<>();
        inpatientRepository.findAll().forEach(inpatient -> list.add(inpatient.toDTO()));
        return list;
    }
}
