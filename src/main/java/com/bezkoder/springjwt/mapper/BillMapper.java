package com.bezkoder.springjwt.mapper;

import com.bezkoder.springjwt.dto.BillDTO;
import com.bezkoder.springjwt.models.Bill;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BillMapper {
    public BillDTO entityToDTO(Bill bill)
    {
        ModelMapper modelMapper = new ModelMapper();
        BillDTO billDTO = modelMapper.map(bill,BillDTO.class);
        return billDTO;
    }

    public List<BillDTO> entityToDTO(List<Bill>bills)
    {
        return bills.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public Bill dtoToEntity(BillDTO billDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        Bill hoaDon = modelMapper.map(billDTO,Bill.class);
        return hoaDon;
    }

    public List<Bill>dtoToEntity(List<BillDTO>billDTOS)
    {
        return billDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
