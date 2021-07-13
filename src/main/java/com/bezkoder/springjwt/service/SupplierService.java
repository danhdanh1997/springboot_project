package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.dto.SupplierDTO;
import com.bezkoder.springjwt.models.Supplier;
import com.bezkoder.springjwt.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    public Optional<Supplier>findOne(Long id){
        return supplierRepository.findById(id);
    }

    public List<Supplier>findAll(){
        return supplierRepository.findAll();
    }

    public Supplier save(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public Supplier update(Long id, Supplier supplierUpdate){
        Optional<Supplier>supplier = supplierRepository.findById(id);
        Supplier supplier1 = supplier.get();
        supplier1.setSupplierName(supplierUpdate.getSupplierName());
        supplier1.setAddress(supplierUpdate.getAddress());
        supplier1.setPhone(supplierUpdate.getPhone());

        Supplier supplier2 = supplierRepository.save(supplier1);
        return supplier2;
    }

    public void delete(Supplier supplier){
        supplierRepository.delete(supplier);
    }
}
