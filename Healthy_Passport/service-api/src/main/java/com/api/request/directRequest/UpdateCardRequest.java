package com.api.request.directRequest;

public class UpdateCardRequest  extends CreateCardRequest{

    private Long id;

    public Long getId() {
        return id;
    }
    public UpdateCardRequest setId(Long id) {
        this.id = id;
        return this;
    }
}
