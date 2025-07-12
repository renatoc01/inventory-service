package com.example.inventory.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class InventoryConsumer {

	private final ObservationRegistry observationRegistry;

	@KafkaListener(topics = "orders", groupId = "inventory-group")
	public void handleOrderEvents(String message) {
		Observation.createNotStarted("inventory.handleOrderEvents", observationRegistry)
				.lowCardinalityKeyValue("kafka.message", message).observe(() -> {
					log.info("[INVENTORY] Received event: {}", message);

					if (message.startsWith("OrderCreated")) {
						log.info("[INVENTORY] Decreasing stock...");
					} else if (message.startsWith("OrderShipped")) {
						log.info("[INVENTORY] Shipping inventory item...");
					}
				});
	}

}
