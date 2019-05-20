package com.bottega.qdocnow.preparation;

import com.bottega.qdocnow.shared.ids.QDocId;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PreparationFacadeTest {

	private PreparationFacade preparationFacade = new PreparationFacade(
			role -> { throw new RuntimeException(""); },
			() -> false,
			new QDocNumberFactory(), null, null,null,null);

	@Test
	public void should_create_new_qdoc() {
		// Given
		QDocId qDocId = new QDocId(UUID.randomUUID());
		PreparationFacade.CreateQDocCommand command = new PreparationFacade.CreateQDocCommand(qDocId, "PJ/1234");

		// When
		preparationFacade.handle(command);

		// Then
		assertThat(preparationFacade.get(qDocId)).isNotNull();

	}
	@Test
	public void should_not_create_when_not_author() {
		// Given
		QDocId qDocId = new QDocId(UUID.randomUUID());
		PreparationFacade.CreateQDocCommand command = new PreparationFacade.CreateQDocCommand(qDocId, "PJ/1234");

		// When Then
		assertThatThrownBy(() -> preparationFacade.handle(command)).isInstanceOf(RuntimeException.class);


	}
}