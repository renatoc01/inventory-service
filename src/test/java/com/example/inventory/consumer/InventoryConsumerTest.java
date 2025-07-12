package com.example.inventory.consumer;

import io.micrometer.observation.ObservationRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryConsumerTest {

	private InventoryConsumer consumer;

	@BeforeEach
	void setUp() {
		ObservationRegistry registry = ObservationRegistry.create();
		consumer = new InventoryConsumer(registry);
	}

	@Test
	void testHandleOrderEvents() {
		String message = "OrderCreated:{\"item\":\"Widget\"}";
		consumer.handleOrderEvents(message);
	}
}
