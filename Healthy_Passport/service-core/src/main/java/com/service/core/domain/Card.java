package com.service.core.domain;

import com.service.core.dao.CardRepository;
import com.service.core.dao.DoctorRepository;
import com.api.request.types.Gender;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Double height;
    @Column
    private Double weight;
    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column
    private String history;
    @Column
    private String hospital;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Patient.class,
            cascade = CascadeType.DETACH)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private Patient patient;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "cards", targetEntity = Doctor.class)
    List<Doctor> doctors = new ArrayList<>();

    public Card() {

    }

    public Card(Double height, Double weight, Gender gender, String history, String hospital, Patient patient) {
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.history = history;
        this.hospital = hospital;
        this.patient = patient;
    }

    //костылизм самый настоящий
    //если нужно удалить карту этот метод удалит у каждого доктора данную карту
    public void removeCard(DoctorRepository doctorRepository, CardRepository cardRepository) {
        for (Doctor doctor : doctors) {
            doctor.getCards().remove(this);
            doctorRepository.saveAndFlush(doctor);
        }
        cardRepository.saveAndFlush(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("id=").append(id);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", gender=").append(gender);
        sb.append(", history='").append(history).append('\'');
        sb.append(", hospital='").append(hospital).append('\'');
        sb.append(", patient=").append(patient);
        sb.append('}');
        return sb.toString();
    }
}
