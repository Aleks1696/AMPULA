package com.api.request.directRequest;

public class CreateDoctorRequest {


    private String name;
    private String surname;


    public String getName() {
        return name;
    }
    public CreateDoctorRequest setName(String name) {
        this.name = name;
        return this;
    }
    public String getSurname() {
        return surname;
    }
    public CreateDoctorRequest setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DoctorDTO{");
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
