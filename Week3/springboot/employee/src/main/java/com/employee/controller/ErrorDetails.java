package com.employee.controller;


import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ErrorDetails {
private String errorMessage;
private LocalDate timestamp;
private int errorCode;
private String toContact;
}
