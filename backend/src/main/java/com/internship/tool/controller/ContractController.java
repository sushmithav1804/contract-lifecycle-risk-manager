package com.internship.tool.controller;

import com.internship.tool.entity.Contract;
import com.internship.tool.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize; // Added
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ContractController {

    private final ContractService contractService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')") // Both roles can view
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')") // Both roles can view details
    public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
        return ResponseEntity.ok(contractService.getContractById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // ONLY Admins can create contracts
    public Contract createContract(@RequestBody Contract contract) {
        return contractService.createContract(contract);
    }
}