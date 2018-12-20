package com.api.dto;

import java.util.Date;
/***
 Data Transfer Object - основное назначение класса,
 передача параметров для Frontend

 PatientDTO:
 0.ID(можно сделать по ИНН)
 1. Фамилия
 2.Имя
 3.год рождения
 4. Сущность " Карточка"

 by Anton Platunov 20.12.2018
 */

public class PatientDTO {

    private Long id;
    private String name;
    private String surname;
    private Date birthday;
    private String card;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PatientDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", card='").append(card).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
