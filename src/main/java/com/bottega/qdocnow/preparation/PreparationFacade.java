package com.bottega.qdocnow.preparation;

import com.bottega.qdocnow.gateway.Command;
import com.bottega.qdocnow.gateway.QDocReadModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public class PreparationFacade {


	public void handle(CreateQDocCommand command) {

	}

	public QDocReadModel get(UUID id) {
		return null;
	}


	@Data
	public static class CreateQDocCommand implements Command {


		private UUID id;
		@NotEmpty
		private String number;
	}

}
