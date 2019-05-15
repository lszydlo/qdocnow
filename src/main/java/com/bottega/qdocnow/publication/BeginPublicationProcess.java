package com.bottega.qdocnow.publication;

import com.bottega.qdocnow.shared.ids.VcId;
import lombok.Data;

@Data
class BeginPublicationProcess {
	private VcId vcId;

	BeginPublicationProcess(VcId vcId) {
		this.vcId = vcId;
	}
}
