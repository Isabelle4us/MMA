package cs631.MMA.controller;

import cs631.MMA.entities.Operation;
import cs631.MMA.entities.Surgeon;
import cs631.MMA.models.OperationDTO;
import cs631.MMA.models.SurgeonDTO;
import cs631.MMA.repositories.OperationRepository;
import cs631.MMA.repositories.SurgeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/surgeon")
public class SurgeonController {
    @Autowired
    private SurgeonRepository surgeonRepository;

    @Autowired
    private OperationRepository operationRepository;

    @PostMapping
    public @ResponseBody Integer addSurgeon(@RequestBody SurgeonDTO surgeonDTO) {
        Surgeon saved = surgeonRepository.save(surgeonDTO.toSurgeon());
        return saved.getId();
    }

    @GetMapping("/{id}")
    public @ResponseBody SurgeonDTO getSurgeonById (@PathVariable Integer id) {
        return surgeonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("surgeonId not found"))
                .toDTO();
    }

    @GetMapping
    public @ResponseBody List<SurgeonDTO> getSurgeons () {
        List<SurgeonDTO> list = new ArrayList<>();
        surgeonRepository.findAll().forEach(surgeon -> list.add(surgeon.toDTO()));
        return list;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody Integer deleteSurgeonById (@PathVariable Integer id) {
        surgeonRepository.deleteById(id);
        return id;
    }

    @PostMapping("/{id}/operation")
    public @ResponseBody List<OperationDTO> getOperations(@PathVariable Integer id, @RequestBody OperationDTO request) {
        return operationRepository.getOperationsByDate(id, request.getDate())
                .stream()
                .map(Operation::toDTO)
                .collect(Collectors.toList());
    }
}
