package org.stdumng.aistudentmanagementsystem;

import jakarta.persistence.*;

@Entity
public class PercentageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double percentage;
    public PercentageEntity() {
    }

    public PercentageEntity(double percentage) {
        this.percentage = percentage;
    }

    public Long getId() {
        return id;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}