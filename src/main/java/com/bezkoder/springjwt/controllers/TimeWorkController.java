package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dto.TimeWorkDTO;
import com.bezkoder.springjwt.exception.ResourceNotFoundException;
import com.bezkoder.springjwt.mapper.TimeWorkMapper;
import com.bezkoder.springjwt.models.TimeWork;
import com.bezkoder.springjwt.service.TimeWorkService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TimeWorkController {
    private final TimeWorkService timeWorkService;
    private final TimeWorkMapper timeWorkMapper;

    public TimeWorkController(TimeWorkService timeWorkService,TimeWorkMapper timeWorkMapper){
        this.timeWorkService=timeWorkService;
        this.timeWorkMapper=timeWorkMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/timework/{id}")
    public ResponseEntity<TimeWorkDTO>getOne(@PathVariable("id") String id){
        Optional<TimeWork> timeWorkOptional = timeWorkService.findOne(id);
        TimeWorkDTO timeWorkDTO = timeWorkMapper.entityToDTO(timeWorkOptional.orElseThrow(()->new ResourceNotFoundException("timework "+id+"not found")));
        return ResponseEntity.ok(timeWorkDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/timeworks")
    public ResponseEntity<List<TimeWorkDTO>>getAll(){
        List<TimeWorkDTO> timeWorkDTO = timeWorkMapper.entityToDTO(timeWorkService.findAll());
        return ResponseEntity.ok(timeWorkDTO);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/timework")
    public ResponseEntity<TimeWorkDTO>create(@RequestBody TimeWork timeWork){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        TimeWorkDTO timeWorkDTO = timeWorkMapper.entityToDTO(timeWorkService.save(timeWork));
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok().headers(headers);
        if(timeWorkDTO!=null){
            return responseBuilder.body(timeWorkDTO);
        }
        else{
            return responseBuilder.body(new TimeWorkDTO());
        }
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/timework/{id}")
    public ResponseEntity<TimeWorkDTO>update(@PathVariable("id")String id, @Valid @RequestBody TimeWork timeWork){
        TimeWorkDTO timeWorkDTO = timeWorkMapper.entityToDTO(timeWorkService.update(id,timeWork));
        return ResponseEntity.ok(timeWorkDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/timework/{id}")
    public Map<String,Boolean>delete(@PathVariable("id")String id){
        Optional<TimeWork>timeWork = timeWorkService.findOne(id);
        TimeWork timeWork1 = timeWork.get();
        timeWorkService.delete(timeWork1);
        Map<String,Boolean>response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
