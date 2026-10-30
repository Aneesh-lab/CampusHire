package com.campushire.campushire.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campushire.campushire.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    boolean existsByStudentAdmissionNumber(String studentAdmissionNumber);
    Optional<Student> findByStudentAdmissionNumber(String studentAdmissionNumber);
    List<Student> findByDepartment(String department);
    List<Student> findByBatch(String batch);
    List<Student> findByCgpaGreaterThanEqual(Double cgpa);
    List<Student> findByBackLogsCountLessThanEqual(Integer maxBacklogs);
}
