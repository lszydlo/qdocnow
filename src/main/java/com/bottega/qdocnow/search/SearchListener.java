package com.bottega.qdocnow.search;

import com.bottega.qdocnow.shared.events.ContentWasUpdated;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SearchListener {


	private final SearchReadModelUpdater updater;

	@EventListener
	public void listenOn(ContentWasUpdated event) {
		updater.updateContent(event);
	}

}
