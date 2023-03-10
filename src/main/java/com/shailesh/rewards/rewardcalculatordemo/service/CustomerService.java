package com.shailesh.rewards.rewardcalculatordemo.service;

import com.shailesh.rewards.rewardcalculatordemo.entity.Customer;
import com.shailesh.rewards.rewardcalculatordemo.helper.Reward;
import com.shailesh.rewards.rewardcalculatordemo.entity.Transaction;
import com.shailesh.rewards.rewardcalculatordemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService{

    @Autowired
    CustomerRepository customerRepository;


    public Map<String, Integer> getRewardsByCustId(long id) {
        List<Reward> rewardList = new ArrayList<>();
        Map<String, Integer> resultMap = null;
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()) {
            List<Transaction> transactions = customer.get().getTransactions();

            transactions.forEach(transaction -> {
                Integer reward = 0;
                if (transaction.getTransactionAmount() > 100) {
                    reward = (int) (reward + ((transaction.getTransactionAmount() - 100) * 2) + 50);
                } else if (transaction.getTransactionAmount() < 100 && transaction.getTransactionAmount() > 50) {
                    reward = (int) (reward + (transaction.getTransactionAmount() - 50));
                } else {
                    reward = 0;
                }
                rewardList.add(new Reward(transaction.getCreateAt(), reward));
            });

            resultMap = rewardList.stream()
                    .collect(
                            Collectors.groupingBy(
                                    Reward::getRewardMonth,
                                    Collectors.summingInt(Reward::getRewardPoint)
                            )
                    );



        }
        return resultMap;
    }
}
