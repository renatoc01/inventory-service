package com.example.inventory.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InventoryConsumer {

	@KafkaListener(topics = "orders", groupId = "inventory-group")
	public void handleOrderEvents(String message) {
		log.info("[INVENTORY] Received event: {}", message);

		if (message.startsWith("OrderCreated")) {
			// Simular decremento do estoque
			log.info("[INVENTORY] Decreasing stock...");
		} else if (message.startsWith("OrderShipped")) {
			log.info("[INVENTORY] Shipping inventory item...");
		}
	}
}
