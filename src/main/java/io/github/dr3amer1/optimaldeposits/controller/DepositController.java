package io.github.dr3amer1.optimaldeposits.controller;

import io.github.dr3amer1.optimaldeposits.entity.Deposit;
import io.github.dr3amer1.optimaldeposits.repository.DepositRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deposits")
@AllArgsConstructor
public class DepositController {

    private final DepositRepository depositRepository;

    @PostMapping
    public Deposit create(@RequestBody Deposit deposit) {
        return depositRepository.save(deposit);
    }

    @GetMapping
    public List<Deposit> getAll() {
        return depositRepository.findAll();
    }
}
