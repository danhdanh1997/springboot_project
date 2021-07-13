package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dto.StaffDTO;
import com.bezkoder.springjwt.exception.ResourceNotFoundException;
import com.bezkoder.springjwt.mapper.StaffMapper;
import com.bezkoder.springjwt.models.Staff;
import com.bezkoder.springjwt.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class StaffController {
    private final StaffService staffService;
    private final StaffMapper staffMapper;
    public StaffController (StaffService staffService,StaffMapper staffMapper){
        this.staffService = staffService;
        this.staffMapper = staffMapper;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/staff/{id}")
    public ResponseEntity<StaffDTO> getById(@PathVariable("id") String id)throws ResourceNotFoundException {
        Optional<Staff>staff = staffService.findOne(id);
        StaffDTO staffDTO = staffMapper.entityToDTO(staff.orElseThrow(()->new ResourceNotFoundException("staff not found"+id)));
        return ResponseEntity.ok(staffDTO);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/staffs")
    public List<StaffDTO> getAll(){
        List<StaffDTO>staffDTOList = staffMapper.entityToDTO(staffService.findAll());
        return staffDTOList;
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/create")
    public ResponseEntity<StaffDTO> create(@Valid @RequestBody Staff staff){
        StaffDTO staffDTO = staffMapper.entityToDTO(staffService.save(staff));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(staffDTO.getId())
                .toUri();
        return ResponseEntity.created(location).body(staffDTO);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("/staff/{id}")
    public ResponseEntity<StaffDTO>update(@PathVariable("id") String id, @RequestBody Staff staffupdate){
        Optional<StaffDTO> staff1 = Optional.ofNullable(staffMapper.entityToDTO(staffService.update(id, staffupdate)));
        return staff1.map(value -> ResponseEntity.ok().body(value))
                     .orElseGet(()-> {
                         StaffDTO staffDTO = staffMapper.entityToDTO(staffService.save(staffupdate));
                         URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                 .path("/{id}")
                                 .buildAndExpand(staffDTO.getId())
                                 .toUri();
                         return ResponseEntity.created(location).body(staffDTO);

        });
    }

    @DeleteMapping("/staff/{id}")
    public Map<String,Boolean>delete(@PathVariable("id") String id){
        Optional<Staff>staff = staffService.findOne(id);
        Staff staff1 = staff.get();
        staffService.delete(staff1);
        Map<String,Boolean>response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

}
