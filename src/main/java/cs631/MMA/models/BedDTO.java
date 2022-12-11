package cs631.MMA.models;

import cs631.MMA.entities.Bed;
import cs631.MMA.entities.Room;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BedDTO {
    private Integer id;
    private Integer roomId;
    private Boolean available;

    public Bed toEntity() {
        return Bed.builder()
                .available(this.available)
                .build();
    }
}
