package cs631.MMA.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value="surgeon-operation")
    private Surgeon surgeon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value="patient-operation")
    private Patient patient;

    @ManyToOne
    private Surgery surgery;

    private String location;

    private LocalDate date;

    private LocalTime start;

    private LocalTime end;

    private Boolean finished;
}
