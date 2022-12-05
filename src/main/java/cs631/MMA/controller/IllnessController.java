package cs631.MMA.controller;

import cs631.MMA.entities.Illness;
import cs631.MMA.entities.Patient;
import cs631.MMA.repositories.IllnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/illness")
public class IllnessController {
    @Autowired
    private IllnessRepository illnessRepository;

    @PostMapping
    public @ResponseBody String addIllness (@RequestBody Illness illness) {
        illnessRepository.save(illness);
        return "illness Added";
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
}
