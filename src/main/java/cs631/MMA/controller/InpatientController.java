package cs631.MMA.controller;

import cs631.MMA.entities.Bed;
import cs631.MMA.entities.Inpatient;
import cs631.MMA.entities.Nurse;
import cs631.MMA.entities.Patient;
import cs631.MMA.models.AssignInpatientRequest;
import cs631.MMA.repositories.BedRepository;
import cs631.MMA.repositories.InpatientRepository;
import cs631.MMA.repositories.NurseRepository;
import cs631.MMA.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @PostMapping
    public @ResponseBody Integer addInpatientToBed(@RequestBody AssignInpatientRequest request) {
        Bed bed = bedRepository.findById(request.getBedId()).orElseThrow(() -> new IllegalArgumentException("bedId not found"));
        Patient patient = patientRepository.findById(request.getPatientId()).orElseThrow(() -> new IllegalArgumentException("patientId not found"));
        Nurse nurse = nurseRepository.findById(request.getNurseId()).orElseThrow(() -> new IllegalArgumentException("patientId not found"));

        Inpatient inpatient = Inpatient.builder()
                .bed(bed)
                .patient(patient)
                .nurse(nurse)
                .build();

        Inpatient saved = inpatientRepository.save(inpatient);
        return saved.getId();
    }
}
