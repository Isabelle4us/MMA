package cs631.MMA.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Surgeon extends Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String contractType;
    private Integer contractLength;
    private String specialty;
}
