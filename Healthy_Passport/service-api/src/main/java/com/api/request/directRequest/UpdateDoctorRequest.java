package com.api.request.directRequest;

public class UpdateDoctorRequest  extends  CreateDoctorRequest{
    private Long id;

    public Long getId() {
        return id;
    }
    public UpdateDoctorRequest setId(Long id) {
        this.id = id;
        return this;
    }
}
