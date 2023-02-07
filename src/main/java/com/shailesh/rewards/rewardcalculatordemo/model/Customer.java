package com.shailesh.rewards.rewardcalculatordemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(targetEntity=Transaction.class)
    @JoinColumn(name="customerId")
    private List<Transaction> transactions = new ArrayList<>();

    @CreationTimestamp
    private Date createAt;

    @UpdateTimestamp
    private Date updatedAt;
}
