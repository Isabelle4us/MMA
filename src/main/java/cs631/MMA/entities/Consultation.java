package cs631.MMA.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value="physician-consultation")
    private Physician physician;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value="patient-consultation")
    private Patient patient;

    @ManyToOne
    private Illness illness;

    private LocalDate date;

    private LocalTime start;

    private LocalTime end;

    private Boolean Diagnosed;

    private Boolean active;
}
