package cs631.MMA.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value="surgeon-operation")
    private Surgeon surgeon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value="patient-operation")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Surgery surgery;

    private String location;

    private LocalDate date;

    private LocalTime start;

    private LocalTime end;
}
