package com.api.dto;

/***
 Data Transfer Object - основное назначение класса,
  передача параметров для Frontend

 CardDTO:
 1.Рост
 2.Вес
 3.Группа крови
 4.Пол
 5.История Болезни(Врач может редактировать и просматривать)
 6.Больница,в которой зарегистрирован пользователь

 by Anton Platunov 20.12.2018

 changed by Aleksandr Borodavka 03.01.2019
 Заменил тип поля gender с Character на String.
 */


public class CardDTO {
    private Long id;

    private Double height;

    private Double weight;

    private String gender;

    private String history;

    private String hospital;

    private String patient;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CardDTO{");
        sb.append("id=").append(id);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", gender=").append(gender);
        sb.append(", history='").append(history).append('\'');
        sb.append(", hospital='").append(hospital).append('\'');
        sb.append(", patient='").append(patient).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
