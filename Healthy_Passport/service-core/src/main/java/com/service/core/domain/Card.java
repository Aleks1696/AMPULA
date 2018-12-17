package com.service.core.domain;

import javax.persistence.*;

/*** Карточка:
 1.Рост
 2.Вес
 3.Группа крови
 4.Пол
 5.История Болезни(Врач может редактировать и просматривать)
 6.Больница,в которой зарегистрирован пользователь

 by Yaroslav Halindzovskiy 17.12.2018
 */

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long height;
    @Column
    private Long weight;
    @Column
    private Character gender;
    @Column
    private String history;
    @Column
    private String hospital;
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "cards", targetEntity = Patient.class)
    private Patient patient;

    public Card() {
    }

    public Card(Long height, Long weight, Character gender, String history, String hospital, Patient patient) {
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.history = history;
        this.hospital = hospital;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
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
