package com.bottega.qdocnow.publication;


import com.bottega.qdocnow.shared.events.VcWasSendToVerification;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PublicationListener {

	private final PublicationFacade publicationFacade;

	@EventListener
	public void listenOn(VcWasSendToVerification event) {
		publicationFacade.handle(new BeginPublicationProcess(event.getVcId()));
	}

}
