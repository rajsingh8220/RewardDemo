package com.shailesh.rewards.rewardcalculatordemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Double transactionAmount;

    private Long customerId;

    @CreationTimestamp
    private Date createAt;

    @UpdateTimestamp
    private Calendar updatedAt;
}
