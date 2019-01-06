package com.api.request.directRequest;

import com.api.request.DoctorsTypes;

/****
 *
 *
 * Yaroslav Halindzovskiy 06.01.2018
 *
 * Изменил странные setter
 *
 *
 * */
public class CreateDoctorRequest {


    private String name;
    private String surname;
    private DoctorsTypes doctorsTypes;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateDoctorRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", doctorsTypes=").append(doctorsTypes);
        sb.append('}');
        return sb.toString();
    }
}
