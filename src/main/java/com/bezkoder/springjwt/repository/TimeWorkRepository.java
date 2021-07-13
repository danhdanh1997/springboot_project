package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.TimeWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeWorkRepository extends JpaRepository<TimeWork,String> {
}
