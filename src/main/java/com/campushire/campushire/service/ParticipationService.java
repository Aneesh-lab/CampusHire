package com.campushire.campushire.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campushire.campushire.dto.ParticipationDTO;
import com.campushire.campushire.entity.Participation;
import com.campushire.campushire.entity.Student;
import com.campushire.campushire.repository.EventRepository;
import com.campushire.campushire.repository.ParticipationRepository;
import com.campushire.campushire.repository.StudentRepository;

import com.campushire.campushire.entity.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParticipationService {

    @Autowired
    private ParticipationRepository participationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EventRepository eventRepository;

    public Participation registerStudentForEvent(String studentAdmissionNumber, String eventId, String eventDescription) {
        Optional<Student> studentOpt = studentRepository.findByStudentAdmissionNumber(studentAdmissionNumber);
        if (studentOpt.isEmpty()) {
            throw new RuntimeException("Student not found");
        }

        Optional<Event> eventOpt = eventRepository.findById(eventId);
        if (eventOpt.isEmpty()) {
            throw new RuntimeException("Event not found");
        }

        Student student = studentOpt.get();
        Event event = eventOpt.get();

        if (participationRepository.existsByStudentAdmissionNumberAndEventId(studentAdmissionNumber, eventId)) {
            throw new RuntimeException("Student is already registered for this event");
        }

        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(event.getRegistrationEnd())) {
            throw new RuntimeException("Registration period has ended for this event");
        }

        Participation participation = new Participation(studentAdmissionNumber, eventId, eventDescription);

        // Denormalize for faster queries
        participation.setStudentFirstName(student.getStudentFirstName());
        participation.setStudentLastName(student.getStudentLastName());
        participation.setStudentDepartment(student.getDepartment());
        participation.setEventName(event.getEventName());
        participation.setOrganizingCompany(event.getOrganizingCompany());
        participation.setJobRole(event.getJobRole());
        participation.setRegistrationStart(event.getRegistrationStart());

        return participationRepository.save(participation);
    }

    public List<ParticipationDTO> getParticipationsByStudent(String admissionNumber) {
        List<Participation> participations = participationRepository.findByStudentAdmissionNumber(admissionNumber);
        return participations.stream()
                .map(ParticipationDTO::new)
                .collect(Collectors.toList());
    }

    public List<ParticipationDTO> getParticipationsByEvent(String eventId) {
        List<Participation> participations = participationRepository.findByEventId(eventId);
        return participations.stream()
                .map(ParticipationDTO::new)
                .collect(Collectors.toList());
    }

    public Participation updateParticipationStatus(String admissionNumber, String eventId, Participation.ParticipationStatus status) {
        Optional<Participation> participationOpt = participationRepository
                .findByStudentAdmissionNumberAndEventId(admissionNumber, eventId);

        if (participationOpt.isEmpty()) {
            throw new RuntimeException("Participation record not found");
        }

        Participation participation = participationOpt.get();
        participation.setStatus(status);
        participation.onUpdate();
        return participationRepository.save(participation);
    }
}