package io.github.dr3amer1.optimaldeposits.controller;

import io.github.dr3amer1.optimaldeposits.entity.Deposit;
import io.github.dr3amer1.optimaldeposits.service.DepositService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deposits")
@AllArgsConstructor
public class DepositController {

    private final DepositService depositService;

    @PostMapping
    public Deposit createDeposit(@RequestBody Deposit deposit) {
        return depositService.createDeposit(deposit);
    }

    @GetMapping
    public List<Deposit> getAllDeposits() {
        return depositService.getDeposits();
    }

    @DeleteMapping
    public void deleteDeposit(@RequestParam Long depositId) {
        depositService.deleteDeposit(depositId);
    }


}
