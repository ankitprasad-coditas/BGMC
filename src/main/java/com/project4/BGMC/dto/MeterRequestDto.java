package com.project4.BGMC.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MeterRequestDto {

    private String meterType;
    private Long meterRate;
    private Long noOfReadings;
    private String timeInterval;
    private boolean isDeleted = false;

}
