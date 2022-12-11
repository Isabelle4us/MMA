package cs631.MMA.controller;

import cs631.MMA.entities.Nurse;
import cs631.MMA.models.NurseDTO;
import cs631.MMA.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/nurse")
public class NurseController {
    @Autowired
    NurseRepository nurseRepository;

    @PostMapping
    public @ResponseBody Integer addNurse (@RequestBody NurseDTO nurseDTO) {
        Nurse saved = nurseRepository.save(nurseDTO.toNurse());
        return saved.getId();
    }

    @GetMapping("/{id}")
    public @ResponseBody NurseDTO getNurseById (@PathVariable Integer id) {
        return nurseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("nurseId not found"))
                .toDTO();
    }

    @GetMapping
    public @ResponseBody List<NurseDTO> getNurses () {
        List<NurseDTO> list = new ArrayList<>();
        nurseRepository.findAll().forEach(nurse -> list.add(nurse.toDTO()));
        return list;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody Integer deleteNurseById (@PathVariable Integer id) {
        nurseRepository.deleteById(id);
        return id;
    }
}