package com.factor.school.Repository;

import com.factor.school.Model.Student_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsRepo extends JpaRepository<Student_details, String> {

    Optional<Student_details> findByMatricNoIgnoreCase(String matric);

    Boolean existsByMatricNoIgnoreCase(String matricNo);

    void deleteByMatricNoIgnoreCase(String matricNo);

}