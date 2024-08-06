package com.max.quizspring.service;

import com.max.quizspring.auth.AppointmentRequest;
import com.max.quizspring.model.Appointment;
import com.max.quizspring.repo.AppointmentRepository;
import com.max.quizspring.repo.PropertyRepository;
import com.max.quizspring.repo.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private AgentRepository agentRepository;

    public Appointment saveAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
        appointment.setDetails(appointmentRequest.getDetails());
        appointment.setProperty(propertyRepository.findById(appointmentRequest.getPropertyId()).orElse(null));
        appointment.setAgent(agentRepository.findById(appointmentRequest.getAgentId()).orElse(null));
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
