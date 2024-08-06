package com.max.quizspring.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyRequest {
    private String name;
    private String city;
    private String state;
    private double price;
    private int bhk;
    private String category;
    private String type;
    private Long agentId;
}
