package cs631.MMA.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AppointmentRequest {
    private Integer physicianId;
    private LocalDate date;
}
