package com.api.request.directRequest;

public class CreateCardRequest {

    private Double height;

    private Double weight;

    private String gender;

    private String history;

    private String hospital;

    private Long patientId;

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
    public String getGender() {
        return gender;
    }
    public CreateCardRequest setGender(String gender) {
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
    public Long getPatient() {
        return patientId;
    }
    public CreateCardRequest setPatient(Long patient) {
        this.patientId = patient;
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
        sb.append(", patient='").append(patientId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
