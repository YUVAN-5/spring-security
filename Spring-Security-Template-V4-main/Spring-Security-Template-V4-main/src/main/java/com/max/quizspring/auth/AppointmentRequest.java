package com.max.quizspring.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequest {
    private LocalDateTime appointmentDate;
    private String details;
    private Long propertyId;
    private Long agentId;
}
