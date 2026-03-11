package com.factor.school.Repository;

import com.factor.school.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

    Optional<Admin> findByStaffId(String username);
}
