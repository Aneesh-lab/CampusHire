package com.campushire.campushire.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campushire.campushire.entity.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByOrganizingCompanyContainingIgnoreCase(String companyName);
    List<Event> findByStatus(Event.EventStatus status);
    List<Event> findByRegistrationStartAfter(LocalDateTime date);
    List<Event> findByRegistrationStartBeforeAndRegistrationEndAfter(LocalDateTime startDate, LocalDateTime endDate);
    List<Event> findByRegistrationEndBefore(LocalDateTime date);
}