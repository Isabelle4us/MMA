package cs631.MMA.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Nurse extends Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer annualSalary;
    private Integer yearOfExp;
    private String grade;
}
