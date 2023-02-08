package com.shailesh.rewards.rewardcalculatordemo.controller;

import com.shailesh.rewards.rewardcalculatordemo.response.CustomerRewardResponse;
import com.shailesh.rewards.rewardcalculatordemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}/reward")
    public CustomerRewardResponse getRewardByCustomer(@PathVariable long id){
        CustomerRewardResponse customerReward = new CustomerRewardResponse();
        Map<String, Integer> lastThreeMonthReward = customerService.getRewardsByCustId(id);
        customerReward.setRewards(lastThreeMonthReward);
        customerReward.setCustomerId(id);

        Integer sum = 0;
        for (int f : lastThreeMonthReward.values()) {
            sum += f;
        }

        customerReward.setTotal(sum);

        return customerReward;
    }
}
