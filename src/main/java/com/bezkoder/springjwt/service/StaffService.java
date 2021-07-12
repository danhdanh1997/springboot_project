package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.Staff;
import com.bezkoder.springjwt.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Optional<Staff>findOne(String id){
        return staffRepository.findById(id);
    }

    public List<Staff>findAll(){
        return staffRepository.findAll();
    }

    public Staff save(Staff staff){
        return staffRepository.save(staff);
    }

    public void delete(Staff staff){
        staffRepository.delete(staff);
    }
}
