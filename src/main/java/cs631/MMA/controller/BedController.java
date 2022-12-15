package cs631.MMA.controller;

import cs631.MMA.entities.Bed;
import cs631.MMA.entities.Clinic;
import cs631.MMA.entities.Room;
import cs631.MMA.models.BedDTO;
import cs631.MMA.repositories.BedRepository;
import cs631.MMA.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/bed")
public class BedController {
    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/availability")
    public @ResponseBody List<BedDTO> getAvailableBeds() {
        return bedRepository.findAllAvailableBeds().stream()
                .map(Bed::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public @ResponseBody Integer createBed(@RequestBody BedDTO bedDTO) {
        Optional<Room> roomOptional = roomRepository.findById(bedDTO.getRoomId());
        Room room = null;
        if (roomOptional.isEmpty()) {
            room = roomRepository.save(new Room(bedDTO.getRoomId()));
        } else {
            room = roomOptional.get();
        }

        Bed bed = bedDTO.toEntity();
        bed.setRoom(room);

        Bed savedBed = bedRepository.save(bed);
        return savedBed.getId();
    }

    @DeleteMapping("/{id}")
    public @ResponseBody Integer deleteBedById(@PathVariable Integer id) {
        bedRepository.deleteById(id);
        return id;
    }
}
