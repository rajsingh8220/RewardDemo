# Rewards Calculator

### Reference Documentation

Dependencies:
- Spring Web
- Spring Data JPA
- Lombok
- H2
- Java 1.8
- Springboot 2.7.8

### Running on Localhost:
- Run the main application (`RewardCalculatorDemoApplication`)
- Make a Get Request using any HTTP client application:
```
GET localhost:8000/customer/1/reward
```

Response:
```json
{
    "customerId": 1,
    "rewards": {
        "2023 January": 90,
        "2023 February": 1200,
        "2022 December": 180
    },
    "total": 1470
}
```
NOTE: Data only available for Customer ID: 1

### Assumptions:
- Database will have only last 3 months of transactions and not old data will be available in the transactions table.
- Code coverage/Unit Tests are not defined (One minor Junit has been done.)


### Developer Note:
Entities:
There are 2 entity classes that represents two database tables (Customer and Transaction). Each customer will have multiple transaction so entities maintain OneToMany relation.
- Customer
- Transaction

There is a helper POJO class that holds intermediate data i.e. `Reward`

- `com.shailesh.rewards.rewardcalculatordemo.repository:` 
This package holds interfaces that extends `JpaRepository`. We use these interfaces in our services to provide business specific data manipulation and read operations.

- `com.shailesh.rewards.rewardcalculatordemo.service:`
Holds all the service classes that define the business specific Data Access Layer.

- `com.shailesh.rewards.rewardcalculatordemo.controller:`
Holds REST API definition along with the URI and the HTTP method for exposed HTTP endpoints.

