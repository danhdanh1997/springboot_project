package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.dto.SupplierDTO;
import com.bezkoder.springjwt.exception.ResourceNotFoundException;
import com.bezkoder.springjwt.mapper.SupplierMapper;
import com.bezkoder.springjwt.models.Supplier;
import com.bezkoder.springjwt.service.SupplierService;
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
public class SupplierController {
    private final SupplierService supplierService;
    private final SupplierMapper supplierMapper;

    public SupplierController(SupplierService supplierService,SupplierMapper supplierMapper){
        this.supplierService = supplierService;
        this.supplierMapper = supplierMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/supplier/{id}")
    public ResponseEntity<SupplierDTO>getOne(@PathVariable("id")Long id) throws ResourceNotFoundException{
        Optional<Supplier> supplierOptional = supplierService.findOne(id);
        SupplierDTO supplierDTO = supplierMapper.entityToDTO(supplierOptional.orElseThrow(()->new ResourceNotFoundException("supplier"+id+"not found")));
        return ResponseEntity.ok(supplierDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/suppliers")
    public ResponseEntity<List<SupplierDTO>>getAll(){
        List<SupplierDTO>supplierList = supplierMapper.entityToDTO(supplierService.findAll());
        return ResponseEntity.ok(supplierList);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/supplier")
    public ResponseEntity<SupplierDTO>create(@Valid @RequestBody Supplier supplier){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        SupplierDTO supplierDTO = supplierMapper.entityToDTO(supplierService.save(supplier));
        ResponseEntity.BodyBuilder responsebuilder = ResponseEntity.ok().headers(headers);
        if(supplierDTO!=null){
            return responsebuilder.body(supplierDTO);
        }
        else{
            return responsebuilder.body(new SupplierDTO());
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/supplier/{id}")
    public ResponseEntity<SupplierDTO>update(@PathVariable("id")Long id, @Valid @RequestBody Supplier supplier){
        SupplierDTO supplierDTO = supplierMapper.entityToDTO(supplierService.update(id, supplier));
        return ResponseEntity.ok().body(supplierDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/supplier/{id}")
    public Map<String,Boolean>delete(@PathVariable("id")Long id){
        Optional<Supplier>supplier = supplierService.findOne(id);
        Supplier supplier1 = supplier.get();
        supplierService.delete(supplier1);
        Map<String,Boolean>response = new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return response;
    }
}
