package com.bottega.qdocnow.shared.events;

import com.bottega.qdocnow.shared.ids.QDocId;
import lombok.Value;

@Value
public class ContentWasUpdated implements DomainEvent{
	private final String content;
	private final QDocId id;


}
