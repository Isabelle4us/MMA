package cs631.MMA.controller;

import cs631.MMA.entities.*;
import cs631.MMA.models.OperationRequest;
import cs631.MMA.models.ScheduleRequest;
import cs631.MMA.repositories.OperationRepository;
import cs631.MMA.repositories.PatientRepository;
import cs631.MMA.repositories.SurgeonRepository;
import cs631.MMA.repositories.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/operation")
public class OperationController {
    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private SurgeonRepository surgeonRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SurgeryRepository surgeryRepository;

    @PostMapping
    public @ResponseBody Integer addOperation(@RequestBody OperationRequest request) {
        Surgeon surgeon = surgeonRepository.findById(request.getSurgeonId()).orElseThrow(() -> new IllegalArgumentException("surgeonId not found"));
        Patient patient = patientRepository.findById(request.getPatientId()).orElseThrow(() -> new IllegalArgumentException("patientId not found"));
        Surgery surgery = surgeryRepository.findById(request.getSurgeryId()).orElseThrow(() -> new IllegalArgumentException("surgeryId not found"));

        Operation operation = Operation.builder()
                .surgeon(surgeon)
                .patient(patient)
                .surgery(surgery)
                .location(request.getLocation())
                .start(request.getStart())
                .end(request.getEnd())
                .date(request.getDate())
                .finished(request.getFinished())
                .build();
        surgeon.getOperations().add(operation);
        Operation saved = operationRepository.save(operation);
        return saved.getId();
    }
}
