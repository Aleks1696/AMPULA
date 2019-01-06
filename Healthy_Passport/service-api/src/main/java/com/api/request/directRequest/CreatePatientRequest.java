package com.api.request.directRequest;

import java.util.Date;

/****
 *
 *
 * Yaroslav Halindzovskiy 06.01.2018
 *
 * Изменил странные setter
 *
 *
 * */

public class CreatePatientRequest {

    private String name;
    private String surname;
    private Date birthday;
    private String card;

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
        final StringBuilder sb = new StringBuilder("CreatePatientRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", card='").append(card).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
