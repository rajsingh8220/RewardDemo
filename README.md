# Rewards Calculator

### Reference Documentation

Dependencies:
- Spring Web
- Spring Data JPA
- Lombok
- H2
- Java 1.8
- Springboot 2.7.8

Running Locally:
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

Assumptions:
- Database will have only last 3 months of transactions and not old data will be available in the transactions table.
- Code coverage/Unit Tests are not defined (One minor Junit has been done.)
