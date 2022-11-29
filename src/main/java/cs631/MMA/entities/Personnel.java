package cs631.MMA.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Long empNo;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String tel;
    private String address;
    private String SSN;
}
