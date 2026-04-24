package com.internship.tool.controller;

import com.internship.tool.entity.Contract;
import com.internship.tool.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Allows the frontend to talk to the backend
public class ContractController {

    private final ContractService contractService;

    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
        return ResponseEntity.ok(contractService.getContractById(id));
    }

    @PostMapping
    public Contract createContract(@RequestBody Contract contract) {
        return contractService.createContract(contract);
    }
}