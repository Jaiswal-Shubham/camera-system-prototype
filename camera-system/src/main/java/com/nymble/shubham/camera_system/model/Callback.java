package com.nymble.shubham.camera_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class Callback {
    private String onSuccess;
    private String onFailure;

    public String getOnSuccess() {
        return onSuccess;
    }

    @JsonIgnore
    public void setSuccessFromCallback(CaptureResult result) {
        this.onSuccess = result.getCapturedImage();
    }

    @JsonIgnore
    public void setOnFailureFromCallback(CaptureResult result) {
        this.onFailure = result.getErrorMessage();
    }
}
