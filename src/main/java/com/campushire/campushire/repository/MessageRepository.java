package com.campushire.campushire.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campushire.campushire.entity.Message;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

    List<Message> findAllByOrderByCreatedAtDesc();

    List<Message> findByStatusOrderByCreatedAtDesc(String status);

    List<Message> findBySenderEmailContainingIgnoreCaseOrSubjectContainingIgnoreCaseOrMessageContainingIgnoreCase(
            String email, String subject, String message);

    long countByStatus(String status);
}
