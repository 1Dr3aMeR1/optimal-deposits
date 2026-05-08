package io.github.dr3amer1.optimaldeposits.controller;

import io.github.dr3amer1.optimaldeposits.dto.BestDepositResponse;
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        depositService.deleteDeposit(id);
    }
    @GetMapping("/best")
    public BestDepositResponse getBest(
            @RequestParam double amount,
            @RequestParam int term
    ) {
        return depositService.findBest(amount, term);
    }


}
