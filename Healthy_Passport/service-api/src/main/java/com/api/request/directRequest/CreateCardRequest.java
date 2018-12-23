package com.api.request.directRequest;

public class CreateCardRequest {

    private Double height;

    private Double weight;

    private Character gender;

    private String history;

    private String hospital;

    private String patient;

    public Double getHeight() {
        return height;
    }
    public CreateCardRequest setHeight(Double height) {
        this.height = height;
        return this;
    }
    public Double getWeight() {
        return weight;
    }
    public CreateCardRequest setWeight(Double weight) {
        this.weight = weight;
        return this;
    }
    public Character getGender() {
        return gender;
    }
    public CreateCardRequest setGender(Character gender) {
        this.gender = gender;
        return this;
    }
    public String getHistory() {
        return history;
    }
    public CreateCardRequest setHistory(String history) {
        this.history = history;
        return this;
    }
    public String getHospital() {
        return hospital;
    }
    public CreateCardRequest setHospital(String hospital) {
        this.hospital = hospital;
        return this;
    }
    public String getPatient() {
        return patient;
    }
    public CreateCardRequest setPatient(String patient) {
        this.patient = patient;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateCardRequest{");
        sb.append("height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", gender=").append(gender);
        sb.append(", history='").append(history).append('\'');
        sb.append(", hospital='").append(hospital).append('\'');
        sb.append(", patient='").append(patient).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
