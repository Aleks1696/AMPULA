package com.api.request.directRequest;

import java.util.Date;

public class CreatePatientRequest {

    private String name;
    private String surname;
    private Date birthday;
    private String card;


    public String getName() {
        return name;
    }
    public CreatePatientRequest setName(String name) {
        this.name = name;
        return this;
    }
    public String getSurname() {
        return surname;
    }
    public CreatePatientRequest setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public Date getBirthday() {
        return birthday;
    }
    public CreatePatientRequest setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }
    public String getCard() {
        return card;
    }
    public CreatePatientRequest setCard(String card) {
        this.card = card;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PatientDTO{");
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", card='").append(card).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
