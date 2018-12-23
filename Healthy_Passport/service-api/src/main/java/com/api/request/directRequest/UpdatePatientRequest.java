package com.api.request.directRequest;

public class UpdatePatientRequest extends  CreatePatientRequest {
    private Long id;

    public Long getId() {
        return id;
    }
    public UpdatePatientRequest setId(Long id) {
        this.id = id;
        return this;
    }
}
