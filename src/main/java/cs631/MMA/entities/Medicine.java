package cs631.MMA.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer medicineCode;

    private String name;

    private Integer quantityOnHand;

    private Integer quantityOnOrder;

    private double unitCost;

    private Integer yearToDateUsage;
}
