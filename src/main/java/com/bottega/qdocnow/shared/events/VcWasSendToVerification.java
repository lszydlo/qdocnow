package com.bottega.qdocnow.shared.events;


import com.bottega.qdocnow.shared.ids.VcId;
import lombok.Value;

@Value
public class VcWasSendToVerification implements DomainEvent{
	private final VcId vcId;
}
