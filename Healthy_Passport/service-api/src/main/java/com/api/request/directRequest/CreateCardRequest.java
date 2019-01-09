package com.api.request.directRequest;


/****
 *
 *
 * Yaroslav Halindzovskiy 06.01.2018
 *
 * Изменил странные setter
 *
 *  Aleksandr Borodavka 08.01.2019
 *  добавил поле Long doctorId + гетеры + сетеры
 * */

public class CreateCardRequest {

    private Double height;
    private Double weight;
    private String gender;
    private String history;
    private String hospital;
    private Long patientId;
    private Long doctorId;


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

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateCardRequest{");
        sb.append("height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", history='").append(history).append('\'');
        sb.append(", hospital='").append(hospital).append('\'');
        sb.append(", patientId=").append(patientId);
        sb.append('}');
        return sb.toString();
    }
}
