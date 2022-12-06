package cs631.MMA.controller;

import cs631.MMA.entities.Consultation;
import cs631.MMA.entities.Operation;
import cs631.MMA.entities.Physician;
import cs631.MMA.entities.Surgeon;
import cs631.MMA.models.AppointmentRequest;
import cs631.MMA.models.ScheduleRequest;
import cs631.MMA.repositories.OperationRepository;
import cs631.MMA.repositories.SurgeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/surgeon")
public class SurgeonController {
    @Autowired
    private SurgeonRepository surgeonRepository;

    @Autowired
    private OperationRepository operationRepository;

    @PostMapping
    public @ResponseBody Integer addSurgeon(@RequestBody Surgeon surgeon) {
        Surgeon saved = surgeonRepository.save(surgeon);
        return saved.getId();
    }

    @GetMapping("/{id}")
    public @ResponseBody Surgeon getSurgeonById (@PathVariable Integer id) {
        return surgeonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("surgeonId not found"));
    }

    @GetMapping
    public @ResponseBody Iterable<Surgeon> getSurgeons () {
        return surgeonRepository.findAll();
    }

    @PostMapping("/{id}/operation")
    public @ResponseBody List<Operation> getOperations(@PathVariable Integer id, @RequestBody ScheduleRequest request) {
        return operationRepository.getOperations(id, request.getDate());
    }
}
