package cs631.MMA.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Surgeon extends Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contractType;
    private Integer contractLength;
    private String specialty;

    @OneToMany(
            mappedBy = "surgeon",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference(value="surgeon-operation")
    private List<Operation> operations;
}
