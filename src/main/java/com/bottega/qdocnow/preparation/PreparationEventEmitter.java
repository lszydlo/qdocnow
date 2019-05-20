package com.bottega.qdocnow.preparation;

import com.bottega.qdocnow.shared.events.ContentWasUpdated;
import com.bottega.qdocnow.shared.events.DomainEvent;

public interface PreparationEventEmitter {
	void emit(ContentWasUpdated domainEvent);
}
