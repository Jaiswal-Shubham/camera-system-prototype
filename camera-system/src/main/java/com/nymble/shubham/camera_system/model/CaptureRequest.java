package com.nymble.shubham.camera_system.model;


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
public class CaptureRequest implements Comparable<CaptureRequest> {
    private int urgency;
    private Callback successCallback;
    private Callback failureCallback;


    @Override
    public int compareTo(CaptureRequest o) {
        return Integer.compare(o.getUrgency(), this.urgency);
    }
}


