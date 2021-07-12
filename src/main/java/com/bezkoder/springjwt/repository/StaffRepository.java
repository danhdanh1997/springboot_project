package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff , String> {
}
