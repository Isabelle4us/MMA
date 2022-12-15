package cs631.MMA.controller;

import cs631.MMA.entities.*;
import cs631.MMA.models.OperationDTO;
import cs631.MMA.repositories.OperationRepository;
import cs631.MMA.repositories.PatientRepository;
import cs631.MMA.repositories.SurgeonRepository;
import cs631.MMA.repositories.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    @PostMapping
    public @ResponseBody Integer addOperation(@RequestBody OperationDTO operationDTO) throws ParseException {
        Surgeon surgeon = surgeonRepository.findById(operationDTO.getSurgeonId()).orElseThrow(() -> new IllegalArgumentException("surgeonId not found"));
        Patient patient = patientRepository.findById(operationDTO.getPatientId()).orElseThrow(() -> new IllegalArgumentException("patientId not found"));
        Surgery surgery = surgeryRepository.findById(operationDTO.getSurgeryId()).orElseThrow(() -> new IllegalArgumentException("surgeryId not found"));

        Operation operation = operationDTO.toOperation();
        operation.setPatient(patient);
        operation.setSurgeon(surgeon);
        operation.setSurgery(surgery);

        patient.getOperations().add(operation);
        surgeon.getOperations().add(operation);

        Date startDate = operationDTO.getStartDate();
        Date dateOnly = formatter.parse(formatter.format(startDate));
        operation.setDate(dateOnly);

        Operation saved = operationRepository.save(operation);
        return saved.getId();
    }

    @GetMapping
    public @ResponseBody List<OperationDTO> getOperations() {
        List<OperationDTO> list = new ArrayList<>();
        operationRepository.findAll().forEach(operation -> list.add(operation.toDTO()));
        return list;
    }
}
