package cs631.MMA.entities;

import cs631.MMA.entities.enumtype.Gender;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String name;
    @Enumerated(EnumType.STRING)
    protected Gender gender;
    protected String tel;
    protected String address;
    protected String SSN;
}
