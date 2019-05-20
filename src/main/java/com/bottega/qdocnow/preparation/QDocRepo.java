package com.bottega.qdocnow.preparation;

import com.bottega.qdocnow.shared.events.DomainEvent;
import com.bottega.qdocnow.shared.ids.QDocId;

import javax.transaction.Transactional;
import java.util.function.Function;

interface QDocRepo {
	void save(PreparationFacade.QDocDraft qDocDraft);

	PreparationFacade.QDocDraft load(QDocId id);


	@Transactional
	default void apply(QDocId id, Function<PreparationFacade.QDocDraft, DomainEvent> function) {
		PreparationFacade.QDocDraft draft = load(id);
		DomainEvent event = function.apply(draft);
		//save(draft);
		//eventStore.append(event);
	}
}
