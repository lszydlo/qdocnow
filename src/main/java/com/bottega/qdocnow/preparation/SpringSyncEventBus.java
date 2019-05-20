package com.bottega.qdocnow.preparation;

import com.bottega.qdocnow.shared.events.DomainEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@AllArgsConstructor
public class SpringSyncEventBus implements SyncEventBus {

	private final ApplicationEventPublisher publisher;

	@Override
	public void publish(DomainEvent domainEvent) {
		publisher.publishEvent(domainEvent);
	}
}
