package com.bottega.qdocnow.search;

import com.bottega.qdocnow.shared.events.ContentWasUpdated;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;

@AllArgsConstructor
public class SearchReadModelUpdater {

	private final JdbcOperations operations;

	public void updateContent(ContentWasUpdated event) {
		operations.update(
				"update read_model set content = ? where id = ?",
				event.getContent(), event.getId());
	}
}
