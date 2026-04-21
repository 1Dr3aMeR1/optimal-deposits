package io.github.dr3amer1.optimaldeposits.repository;

import io.github.dr3amer1.optimaldeposits.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
}
