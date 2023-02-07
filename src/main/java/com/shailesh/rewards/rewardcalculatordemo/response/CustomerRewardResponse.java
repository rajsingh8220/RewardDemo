package com.shailesh.rewards.rewardcalculatordemo.response;

import com.shailesh.rewards.rewardcalculatordemo.model.Reward;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRewardResponse {
    private Long customerId;
    private Map<String, Integer> rewards;
    private Integer total;
}
