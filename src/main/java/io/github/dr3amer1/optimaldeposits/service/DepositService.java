package io.github.dr3amer1.optimaldeposits.service;

import io.github.dr3amer1.optimaldeposits.dto.BestDepositResponse;
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

    public BestDepositResponse findBest(double amount, int termMonths) {
        List<Deposit> deposits = depositRepository.findAll();

        Deposit bestDeposit = null;
        double bestProfit = -1;

        for (Deposit deposit : deposits) {
            boolean amountMatches = amount >= deposit.getMinAmount() && amount <= deposit.getMaxAmount();
            boolean termMatches = termMonths == deposit.getTermMonths();

            if (amountMatches && termMatches) {
                double profit = calculateProfit(deposit, amount, termMonths);

                if (profit > bestProfit) {
                    bestProfit = profit;
                    bestDeposit = deposit;
                }
            }
        }

        BestDepositResponse response = new BestDepositResponse();
        response.setAmount(amount);

        if (bestDeposit == null) {
            response.setFound(false);
            response.setMessage("No suitable deposits found");
            return response;
        }

        response.setFound(true);
        response.setMessage("Best deposit found");
        response.setDepositId(bestDeposit.getId());
        response.setDepositName(bestDeposit.getName());
        response.setInterestRate(bestDeposit.getInterestRate());
        response.setTermMonths(bestDeposit.getTermMonths());
        response.setProfit(bestProfit);
        response.setTotalAmount(amount + bestProfit);

        return response;
    }

    private double calculateProfit(Deposit deposit, double amount, int termMonths) {
        return amount * (deposit.getInterestRate() / 100.0) * (termMonths / 12.0);
    }

}
