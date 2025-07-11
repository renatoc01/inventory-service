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

## 🚀 CI/CD Pipeline

- Checkout Code: Retrieves the latest code from the main branch.
- JDK Setup: Installs Java 17 (Temurin) required for building and running tests.
- Maven Cache: Caches dependencies to speed up the build process.
- Permission Setup: Grants execute permission for the Maven wrapper script (./mvnw).
- Build: Compiles and packages the application using Maven (./mvnw clean install).
- Test Execution: Runs unit and integration tests to ensure code correctness.
- Docker Image Build: Creates a Docker image tagged as inventory-service:latest for container deployment.

## 🎯 Observability

We implemented observability across all microservices (order-service, inventory-service, notification-service) using:

- Spring Boot Actuator for health checks, metrics, and tracing endpoints.
- Micrometer with Prometheus integration for metrics collection.
- Prometheus to scrape metrics from services.
- Grafana for visualizing metrics dashboards.
- Zipkin for distributed tracing to analyze request flows across services.

Each service exposes a /actuator/prometheus endpoint for metrics and reports tracing data to Zipkin.

The infrastructure is orchestrated via Docker Compose, which includes Kafka, Zookeeper, Zipkin, Prometheus, and Grafana containers, along with the microservices.
