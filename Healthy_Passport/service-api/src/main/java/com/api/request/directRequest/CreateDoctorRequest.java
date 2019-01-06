package com.api.request.directRequest;

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
    private String doctorType;

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

    public com.service.core.domain.types.DoctorsTypes getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateDoctorRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", doctorType='").append(doctorType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
