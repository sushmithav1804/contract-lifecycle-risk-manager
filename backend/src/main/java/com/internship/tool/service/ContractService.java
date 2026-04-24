package com.internship.tool.service;

import com.internship.tool.entity.Contract;
import com.internship.tool.exception.ResourceNotFoundException;
import com.internship.tool.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict; // Added
import org.springframework.cache.annotation.Cacheable; // Added
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    // Checks Redis first. If empty, runs the SQL and saves the list to Redis.
    @Cacheable(value = "contracts")
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    // Checks Redis for a specific contract ID.
    @Cacheable(value = "contracts", key = "#id")
    public Contract getContractById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found with id: " + id));
    }

    // When a new contract is saved, the old list in Redis is outdated.
    // allEntries = true deletes the whole "contracts" cache so the next GET refreshes it.
    @CacheEvict(value = "contracts", allEntries = true)
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }
}