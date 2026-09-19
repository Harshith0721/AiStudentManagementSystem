package org.stdumng.aistudentmanagementsystem;

import jakarta.persistence.*;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private long standard;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "percentage_id")
    private PercentageEntity percentage;
    public StudentEntity() {}
    public StudentEntity(long standard, PercentageEntity percentage, String lastName, String firstName) {
        this.standard = standard;
        this.percentage = percentage;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public long getStandard() {
        return standard;
    }

    public void setStandard(long standard) {
        this.standard = standard;
    }

    public PercentageEntity getPercentage() {
        return percentage;
    }

    public void setPercentage(PercentageEntity percentage) {
        this.percentage = percentage;
    }
}
