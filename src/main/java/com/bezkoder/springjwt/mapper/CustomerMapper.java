package com.bezkoder.springjwt.mapper;


import com.bezkoder.springjwt.dto.BillDTO;
import com.bezkoder.springjwt.dto.CustomerDTO;
import com.bezkoder.springjwt.models.Bill;
import com.bezkoder.springjwt.models.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public CustomerDTO entityToDTO(Customer customer)
    {
        ModelMapper modelMapper = new ModelMapper();
        CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
        return customerDTO;
    }

    public List<CustomerDTO> entityToDTO(List<Customer>customers)
    {
        return customers.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public Customer dtoToEntity(CustomerDTO customerDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerDTO,Customer.class);
        return customer;
    }

    public List<Customer>dtoToEntity(List<CustomerDTO>customerDTOS)
    {
        return customerDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
