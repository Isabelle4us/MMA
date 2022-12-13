package cs631.MMA.controller;

import cs631.MMA.entities.Illness;
import cs631.MMA.entities.Patient;
import cs631.MMA.repositories.IllnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/illness")
public class IllnessController {
    @Autowired
    private IllnessRepository illnessRepository;

    @PostMapping
    public @ResponseBody Integer addIllness (@RequestBody Illness illness) {
        Illness saved = illnessRepository.save(illness);
        return saved.getId();
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String deleteIllness (@PathVariable Integer id) {
        illnessRepository.deleteById(id);
        return "Patient Deleted";
    }

    @GetMapping("/{id}")
    public @ResponseBody Illness getIllness (@PathVariable Integer id) {
        return illnessRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No illness found"));
    }

    @GetMapping
    public @ResponseBody Iterable<Illness> getIllnesses () {
        return illnessRepository.findAll();
    }
}
