package cs631.MMA.models;

import cs631.MMA.entities.Surgeon;
import cs631.MMA.entities.enumtype.Gender;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SurgeonDTO {
    private Integer id;
    private String name;
    private Gender gender;
    private String tel;
    private String address;
    private String SSN;
    private String contractType;
    private Integer contractLength;
    private String specialty;

    public Surgeon toSurgeon() {
        return Surgeon.builder()
                .name(this.name)
                .gender(this.gender)
                .tel(this.tel)
                .address(this.address)
                .SSN(this.SSN)
                .contractType(this.contractType)
                .specialty(this.specialty)
                .contractLength(this.contractLength)
                .build();
    }
}
