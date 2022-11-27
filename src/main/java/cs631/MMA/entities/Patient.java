package cs631.MMA.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private Long patientNo;
    private String name;
    private String tel;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;
    private Double bloodSugar;
    private Double HDL;
    private Double LDL;
    private Double triglyceride;
    private String SSN;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(Long patientNo) {
        this.patientNo = patientNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Double getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(Double bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public Double getHDL() {
        return HDL;
    }

    public void setHDL(Double HDL) {
        this.HDL = HDL;
    }

    public Double getLDL() {
        return LDL;
    }

    public void setLDL(Double LDL) {
        this.LDL = LDL;
    }

    public Double getTriglyceride() {
        return triglyceride;
    }

    public void setTriglyceride(Double triglyceride) {
        this.triglyceride = triglyceride;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
}
