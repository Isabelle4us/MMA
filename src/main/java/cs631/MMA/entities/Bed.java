package cs631.MMA.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import cs631.MMA.models.BedDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    private Boolean available;

    public BedDTO toDTO() {
        return BedDTO.builder()
                .id(this.id)
                .roomId(this.room.getId())
                .available(this.available)
                .build();
    }
}
