package com.bottega.qdocnow.gateway;

import com.bottega.qdocnow.shared.ids.QDocId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QDocReadModel {

	private QDocId qDocId;
	private String content;
	private String number;

}
