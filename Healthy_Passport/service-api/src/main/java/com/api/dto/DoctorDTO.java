package com.api.dto;

/****
 * DoctorDTO:
 * 1.Имя.
 * 2.Фамилия
 * 3.Какой врач(Хирург,кардиолог и тд)
 *
 *  Anton Platunov 20.12.2018
 * */

public class DoctorDTO {

    private Long id;

    private String name;

    private String surname;

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
