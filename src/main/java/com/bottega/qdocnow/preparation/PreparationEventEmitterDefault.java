package com.bottega.qdocnow.preparation;

import com.bottega.qdocnow.search.SearchReadModelUpdater;
import com.bottega.qdocnow.shared.events.ContentWasUpdated;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PreparationEventEmitterDefault implements PreparationEventEmitter {

	private final SearchReadModelUpdater updater;

	@Override
	public void emit(ContentWasUpdated domainEvent) {
		updater.updateContent(domainEvent);
	}
}
