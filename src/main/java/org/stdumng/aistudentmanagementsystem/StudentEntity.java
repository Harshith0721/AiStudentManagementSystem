package org.stdumng.aistudentmanagementsystem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private long standard;
    public StudentEntity() {}
    public StudentEntity(String firstName, String lastName, long standard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.standard = standard;
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
}
