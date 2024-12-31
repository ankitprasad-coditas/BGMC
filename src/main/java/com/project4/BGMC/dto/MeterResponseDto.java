package com.project4.BGMC.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MeterResponseDto {

    private Long id;
    private String meterType;
    private Long meterRate;
    private Long noOfReadings;
    private String timeInterval;
    private boolean isDeleted = false;

}
