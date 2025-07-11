# 📦 Inventory Service

This microservice listens to Kafka events related to orders and simulates inventory operations such as stock reduction and shipping.

## 🚀 Getting Started

### 🧑‍💻 Run Locally

```bash
./mvnw spring-boot:run
```

## 🐳 Run with Docker

```bash
docker build -t inventory-service .
docker run -p 8081:8081 inventory-service
```
The service listens on port 8081 by default.

## 🔗 Kafka Integration

- **Topic:** `orders`  
- **Group ID:** `inventory-group`

When messages are received, the service logs inventory actions depending on the event type:

```java
[INVENTORY] Received event: OrderCreated:{...}
[INVENTORY] Decreasing stock...
```

```java
[INVENTORY] Received event: OrderShipped:{...}
[INVENTORY] Shipping inventory item...
```

## 🧪 Testing

This service includes a unit test for the consumer logic.

To run the tests:

```bash
./mvnw test
```

## 📂 Directory Structure

This service includes a unit test for the consumer logic.

To run the tests:

```plaintext
inventory-service/
├── src/
│   ├── main/
│   │   └── java/com/example/inventory/
│   │       └── consumer/
│   │           └── InventoryConsumer.java
│   └── test/
│       └── java/com/example/inventory/
│           └── consumer/
│               └── InventoryConsumerTest.java
├── pom.xml
└── README.md
```

## ⚙️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Kafka**
- **JUnit 5**
- **Docker**
