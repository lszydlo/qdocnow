package com.bottega.qdocnow.preparation;

import com.bottega.qdocnow.gateway.Command;
import com.bottega.qdocnow.gateway.QDocReadModel;
import com.bottega.qdocnow.shared.ids.QDocId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
public class PreparationFacade {

	private final CurrentUserPort userPort;

	public void handle(CreateQDocCommand command) {
		userPort.checkRole("AUTHOR");
		QDocDraft draft = new QDocDraft(command.getId(),new QDocNumber(command.getNumber()));

	}

	public QDocReadModel get(QDocId id) {
		return null;
	}


	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CreateQDocCommand implements Command {


		private QDocId id;
		@NotEmpty
		private String number;
	}

	private class QDocDraft {
		private final QDocId id;
		private final QDocNumber number;

		QDocDraft(QDocId id, QDocNumber number) {
			this.id = id;
			this.number = number;
		}
	}
}
