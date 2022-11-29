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
    public @ResponseBody String addPhysician (@RequestBody Physician physician) {
        physicianRepository.save(physician);
        return "Physician Added";
    }

    @GetMapping("/{empNo}")
    public @ResponseBody Physician getPhysicianById (@PathVariable Long empNo) {
        return physicianRepository.getPhysicianByEmpNo(empNo);
    }
}
