package com.shailesh.rewards.rewardcalculatordemo.repository;

import com.shailesh.rewards.rewardcalculatordemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
