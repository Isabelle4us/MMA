package cs631.MMA.controller;

import cs631.MMA.entities.Surgery;
import cs631.MMA.repositories.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/surgery")
public class SurgeryController {
    @Autowired
    private SurgeryRepository surgeryRepository;

    @PostMapping
    public Integer addSurgery(@RequestBody Surgery surgery) {
        System.out.println(surgery);
        Surgery saved = surgeryRepository.save(surgery);
        return saved.getId();
    }

    @GetMapping("/{id}")
    public Surgery getSurgeryById(@PathVariable Integer id) {
        return surgeryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no surgery id found"));
    }

    @DeleteMapping("/{id}")
    public Integer deleteSurgeryById(@PathVariable Integer id) {
        surgeryRepository.deleteById(id);
        return id;
    }

    @GetMapping
    public Iterable<Surgery> getSurgeries() {
        return surgeryRepository.findAll();
    }
}
