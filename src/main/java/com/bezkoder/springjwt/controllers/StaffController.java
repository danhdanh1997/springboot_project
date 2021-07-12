package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dto.StaffDTO;
import com.bezkoder.springjwt.exception.ResourceNotFoundException;
import com.bezkoder.springjwt.mapper.StaffMapper;
import com.bezkoder.springjwt.models.Staff;
import com.bezkoder.springjwt.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/")
public class StaffController {
    private final StaffService staffService;
    private final StaffMapper staffMapper;
    public StaffController (StaffService staffService,StaffMapper staffMapper){
        this.staffService = staffService;
        this.staffMapper = staffMapper;
    }

    @GetMapping("staff/{id}")
    public ResponseEntity<StaffDTO> getById(@PathVariable("id") String id)throws ResourceNotFoundException {
        Optional<Staff>staff = staffService.findOne(id);
        StaffDTO staffDTO = staffMapper.entityToDTO(staff.orElseThrow(()->new ResourceNotFoundException("staff not found"+id)));
        return ResponseEntity.ok(staffDTO);
    }


}
