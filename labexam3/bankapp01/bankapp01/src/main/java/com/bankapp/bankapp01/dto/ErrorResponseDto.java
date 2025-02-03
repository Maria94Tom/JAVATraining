package com.bankapp.bankapp01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDto {
    private String errorMessage;
    private String errorCode;
    private String toContact;
    private LocalDateTime timeStamp;


}
