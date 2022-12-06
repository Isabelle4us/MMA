package cs631.MMA.repositories;

import cs631.MMA.entities.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {
}
