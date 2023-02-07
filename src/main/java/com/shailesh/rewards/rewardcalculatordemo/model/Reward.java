package com.shailesh.rewards.rewardcalculatordemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reward {
    private Date rewardDate;
    private Integer rewardPoint;

    public String getRewardMonth(){
        SimpleDateFormat simpleformat = new SimpleDateFormat("YYYY MMMM");
        return simpleformat.format(this.rewardDate);
    }
}
