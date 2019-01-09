package com.api.dto;

/****
 * DoctorDTO:
 * 1.Имя.
 * 2.Фамилия
 * 3.Какой врач(Хирург,кардиолог и тд)
 *
 *  Anton Platunov 20.12.2018
 *
 *
 *  Yaroslav Halindzovskiy 6.01.2017
 *   Добавил DoctorType в ввиде строки.
 *
 *   Aleksandr Borodavka 08.01.2018
 *   Добавил гетеры и сетеры на поле String doctorType
 * */

public class DoctorDTO {

    private Long id;
    private String name;
    private String surname;
    private String doctorType;

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

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DoctorDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
