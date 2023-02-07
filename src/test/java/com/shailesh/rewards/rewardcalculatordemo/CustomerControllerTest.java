package com.shailesh.rewards.rewardcalculatordemo;

import com.shailesh.rewards.rewardcalculatordemo.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private CustomerService service;

    @Autowired private MockMvc mockMvc;

    @Test
    void getAllTransactions() throws Exception {
        mockMvc.perform(get("/customer/1/reward"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("total").value(1470));
    }

}
