package cs631.MMA.controller;

import cs631.MMA.entities.Bed;
import cs631.MMA.entities.Clinic;
import cs631.MMA.entities.Room;
import cs631.MMA.repositories.BedRepository;
import cs631.MMA.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/bed")
public class BedController {
    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private RoomRepository RoomRepository;

    @GetMapping("/availability")
    public @ResponseBody Iterable<Bed> getAvailableBeds() {
        return bedRepository.findAllAvailableBeds();
    }

    @PostMapping("/{roomId}")
    public @ResponseBody Integer createBed(@PathVariable Integer roomId) {
        Room room = RoomRepository.findById(roomId).orElseThrow(() -> new IllegalArgumentException("roomId not exists"));
        Bed bed = Bed.builder()
                .room(room)
                .available(true)
                .build();
        room.getBeds().add(bed);
        Bed savedBed = bedRepository.save(bed);
        return savedBed.getId();
    }
}
