package com.campushire.campushire.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campushire.campushire.entity.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    Optional<Admin> findByEmailAddress(String emailAddress);
    boolean existsByEmailAddress(String emailAddress);
   Optional<Admin> findById(String id);
}
