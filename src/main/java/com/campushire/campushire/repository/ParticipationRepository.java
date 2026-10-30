package com.campushire.campushire.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campushire.campushire.entity.Participation;

@Repository
public interface ParticipationRepository extends MongoRepository<Participation, String> {

    boolean existsByStudentAdmissionNumberAndEventId(String studentAdmissionNumber, String eventId);

    List<Participation> findByStudentAdmissionNumber(String admissionNumber);

    List<Participation> findByEventId(String eventId);

    List<Participation> findByOrganizingCompany(String companyName);

    Optional<Participation> findByStudentAdmissionNumberAndEventId(String admissionNumber, String eventId);

    void deleteByEventId(String eventId);

    void deleteByStudentAdmissionNumber(String studentAdmissionNumber);
}
