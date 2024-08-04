package com.nymble.shubham.camera_system.model;


public class CaptureResult {
    private String capturedImage;
    private String errorMessage;

    public CaptureResult(String capturedImage, String errorMessage) {
        this.capturedImage = capturedImage;
        this.errorMessage = errorMessage;
    }

    public String getCapturedImage() {
        return capturedImage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

