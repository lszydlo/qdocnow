package com.bottega.qdocnow.preparation;

import com.bottega.qdocnow.gateway.Command;
import com.bottega.qdocnow.gateway.QDocReadModel;
import com.bottega.qdocnow.preparation.QDocNumberFactory.QDocNumber;
import com.bottega.qdocnow.shared.events.ContentWasUpdated;
import com.bottega.qdocnow.shared.events.DomainEvent;
import com.bottega.qdocnow.shared.events.QDocWasCreated;
import com.bottega.qdocnow.shared.ids.QDocId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
public class PreparationFacade {

	private final CurrentUserPort userPort;
	private final SystemConfig systemConfig;
	private final QDocNumberFactory numberFactory;
	private final QDocRepo repo;
	private final QDocFinder finder;
	private final SyncEventBus syncEventBus;
	private final PreparationEventEmitter eventEmiter;

	public void handle(CreateQDocCommand command) {
		//userPort.checkRole("AUTHOR");
		QDocNumber number = numberFactory.generate(
				systemConfig.isDemo(),
				command.getNumber());

		repo.apply(command.id, qDocDraft -> qDocDraft.create(command.id, number));

	}

	public void handle(UpdateContentCommand command) {

		repo.apply(command.getId(), qDocDraft -> qDocDraft.updateContent(command.getContent()));

//
//
//		QDocDraft qDocDraft = repo.load(command.getId());
//		DomainEvent domainEvent = qDocDraft.updateContent(command.getContent());
////		syncEventBus.publish(domainEvent);
////		eventEmitter.emit((ContentWasUpdated) domainEvent);
//		repo.save(qDocDraft,domainEvent);
	}

	public QDocReadModel get(QDocId id) {
		return finder.find(id);
	}


	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CreateQDocCommand implements Command {


		private QDocId id;
		@NotEmpty
		private String number;
	}

	@Entity
	static class QDocDraft {
		@Id
		private QDocId id;
		private QDocNumber number;
		private QDocContent content;

		public QDocDraft() {
		}

		QDocDraft(QDocId id, QDocNumber number) {
			this.id = id;
			if (number == null) {
				throw new RuntimeException("number is null");
			}
			this.number = number;
		}

		DomainEvent updateContent(String content) {
			this.content = new QDocContent(content);
			return new ContentWasUpdated(content, id);
		}

		QDocReadModel toReadModel() {
			return new QDocReadModel(id, content.getValue(), number.getValue());
		}

		DomainEvent create(QDocId id, QDocNumber number) {
			return new QDocWasCreated();
		}
	}
}
