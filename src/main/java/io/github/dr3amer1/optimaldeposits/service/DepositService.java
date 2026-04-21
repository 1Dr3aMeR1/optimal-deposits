package io.github.dr3amer1.optimaldeposits.service;

import io.github.dr3amer1.optimaldeposits.entity.Deposit;
import io.github.dr3amer1.optimaldeposits.repository.DepositRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepositService {

    private final DepositRepository depositRepository;

    public Deposit createDeposit(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    public List<Deposit> getDeposits() {
        return depositRepository.findAll();
    }

    public void deleteDeposit(Long id) {
        depositRepository.deleteById(id);
    }

}
