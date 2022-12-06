package cs631.MMA.controller;

import cs631.MMA.entities.Patient;
import cs631.MMA.entities.Physician;
import cs631.MMA.repositories.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/physician")
public class PhysicianController {
    @Autowired
    PhysicianRepository physicianRepository;

    @PostMapping
    public @ResponseBody Integer addPhysician (@RequestBody Physician physician) {
        Physician saved = physicianRepository.save(physician);
        return saved.getId();
    }

    @GetMapping("/{id}")
    public @ResponseBody Physician getPhysicianById (@PathVariable Integer id) {
        return physicianRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("physicianId not found"));
    }

    @GetMapping
    public @ResponseBody Iterable<Physician> getPhysicians (@PathVariable Integer id) {
        return physicianRepository.findAll();
    }
}
