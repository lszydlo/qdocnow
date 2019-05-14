package com.bottega.qdocnow.gateway;

import com.bottega.qdocnow.preparation.PreparationFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class QDocController {


	private final PreparationFacade preparationFacade;


	@PutMapping("/qdocs/{id}")
	public ResponseEntity<QDocReadModel> createQDoc(@Valid @RequestBody PreparationFacade.CreateQDocCommand command) {

		preparationFacade.handle(command);
		QDocReadModel model = preparationFacade.get(command.getId());
		return ResponseEntity.ok(model);
	}

}
