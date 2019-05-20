package com.bottega.qdocnow.preparation;

import lombok.Value;

class QDocNumberFactory {
	QDocNumber generate(boolean isDemo, String number) {
		return new QDocNumber(isDemo ? "DEMO/" + number : number);
	}

	@Value
	static class QDocNumber {

		private final String value;


		private QDocNumber(String value) {
			// validation
			this.value = value;
		}
	}
}
