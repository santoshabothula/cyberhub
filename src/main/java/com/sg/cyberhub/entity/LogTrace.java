package com.sg.cyberhub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class LogTrace {
    @Id
    @GeneratedValue
    private Long id;
    private String correlationId;
    private String className;
    private String method;
    private String log;
    private Long totalTimeTaken;
    private String api;
    private String apiMethod;
    private String request;
    private String response;
}
