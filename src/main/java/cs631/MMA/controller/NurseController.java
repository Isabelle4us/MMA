package cs631.MMA.controller;

import cs631.MMA.entities.Nurse;
import cs631.MMA.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/nurse")
public class NurseController {
    @Autowired
    NurseRepository nurseRepository;

    @PostMapping
    public @ResponseBody Integer addPhysician (@RequestBody Nurse nurse) {
        Nurse saved = nurseRepository.save(nurse);
        return saved.getId();
    }

    @GetMapping("/{id}")
    public @ResponseBody Nurse getPhysicianById (@PathVariable Integer id) {
        return nurseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("nurseId not found"));
    }

    @GetMapping
    public @ResponseBody Iterable<Nurse> getPhysicians () {
        return nurseRepository.findAll();
    }
}