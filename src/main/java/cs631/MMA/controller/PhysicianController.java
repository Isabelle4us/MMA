package cs631.MMA.controller;

import cs631.MMA.entities.Patient;
import cs631.MMA.entities.Physician;
import cs631.MMA.models.PatientDTO;
import cs631.MMA.models.PhysicianDTO;
import cs631.MMA.repositories.PhysicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/physician")
public class PhysicianController {
    @Autowired
    PhysicianRepository physicianRepository;

    @PostMapping
    public @ResponseBody Integer addPhysician (@RequestBody PhysicianDTO physicianDTO) {
        Physician saved = physicianRepository.save(physicianDTO.toPhysician());
        return saved.getId();
    }

    @GetMapping("/{id}")
    public @ResponseBody Physician getPhysicianById (@PathVariable Integer id) {
        return physicianRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("physicianId not found"));
    }

    @DeleteMapping("/{id}")
    public @ResponseBody Integer deletePhysicianById (@PathVariable Integer id) {
        physicianRepository.deleteById(id);
        return id;
    }

    @GetMapping
    public @ResponseBody Iterable<PhysicianDTO> getPhysicians () {
        List<PhysicianDTO> allPhysicians = new ArrayList<>();
        physicianRepository.findAll().forEach(physician -> allPhysicians.add(physician.toDTO()));
        return allPhysicians;
    }
}
