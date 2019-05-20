package com.bottega.qdocnow.preparation;

import com.bottega.qdocnow.shared.events.DomainEvent;

public interface SyncEventBus {
	void publish(DomainEvent domainEvent);
}
