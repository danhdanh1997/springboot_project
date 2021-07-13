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

    public Staff update(String id , Staff staffUpdate){
        Optional<Staff>staff = staffRepository.findById(id);
        Staff staff1 = staff.get();
        staff1.setImage(staffUpdate.getImage());
        staff1.setPhone(staffUpdate.getPhone());
        staff1.setAddress(staffUpdate.getAddress());
        staff1.setGender(staffUpdate.getGender());
        staff1.setDateOfBirth(staffUpdate.getDateOfBirth());
        staff1.setFirstName(staffUpdate.getFirstName());
        staff1.setLastName(staffUpdate.getLastName());
        staff1.setStartWorkDay(staffUpdate.getStartWorkDay());

        Staff staff2 = staffRepository.save(staff1);
        return  staff2;
    }

    public void delete(Staff staff){
        staffRepository.delete(staff);
    }
}
