package com.service.core.domain;


import com.service.core.domain.types.DoctorsTypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/****
 * Врач:
 * 1.Имя.
 * 2.Фамилия
 * 3.Какой врач(Хирург,кардиолог и тд)
 *
 * 20.12.2018 - by Yaroslav Halindzovskiy
 * */
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private DoctorsTypes doctorsTypes;
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Patient.class)
    @JoinTable(name = "record_on_patients", joinColumns = @JoinColumn(name = "doctors_ref_id", referencedColumnName = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_ref_id", referencedColumnName = "patient_id"))
    private List<Patient> patients = new ArrayList<Patient>();

    public Doctor() {
    }

    public Doctor(String name, String surname, DoctorsTypes doctorsTypes, List<Patient> patients) {
        this.name = name;
        this.surname = surname;
        this.doctorsTypes = doctorsTypes;
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public DoctorsTypes getDoctorsTypes() {
        return doctorsTypes;
    }

    public void setDoctorsTypes(DoctorsTypes doctorsTypes) {
        this.doctorsTypes = doctorsTypes;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Doctor{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", doctorsTypes=").append(doctorsTypes);
        sb.append(", patients=").append(patients);
        sb.append('}');
        return sb.toString();
    }
}
