package com.bottega.qdocnow.preparation;

import com.bottega.qdocnow.gateway.QDocReadModel;
import com.bottega.qdocnow.shared.ids.QDocId;

public interface QDocFinder {
	QDocReadModel find(QDocId id);
}
