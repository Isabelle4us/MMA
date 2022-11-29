package cs631.MMA.controller;

import cs631.MMA.entities.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import cs631.MMA.repositories.ClinicRepository;

@Controller
@RequestMapping(path="/clinic")
public class ClinicController {
    @Autowired
    private ClinicRepository clinicRepository;

    @PostMapping
    public @ResponseBody String addClinic (@RequestBody Clinic clinic) {
        clinicRepository.save(clinic);
        return "Clinic Saved";
    }

    @GetMapping
    public @ResponseBody Iterable<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }
}
