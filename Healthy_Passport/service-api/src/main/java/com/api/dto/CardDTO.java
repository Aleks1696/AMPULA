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
    private String name;
    private String surname;
    private String birthday;
    private Double height;
    private Double weight;
    private String gender;
    private String history;
    private String hospital;
    private String doctor;

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
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
    public String getDoctor() {
        return doctor;
    }
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CardDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", birthday='").append(birthday).append('\'');
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", history='").append(history).append('\'');
        sb.append(", hospital='").append(hospital).append('\'');
        sb.append(", doctor='").append(doctor).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
