package com.internship.tool.service;

import com.internship.tool.entity.Contract;
import com.internship.tool.exception.ResourceNotFoundException;
import com.internship.tool.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    public Contract getContractById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found with id: " + id));
    }

    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }
}
