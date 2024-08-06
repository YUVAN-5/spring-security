package com.max.quizspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime appointmentDate;
    private String details;
    
    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
    
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;
}
