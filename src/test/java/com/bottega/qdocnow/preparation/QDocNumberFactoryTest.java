package com.bottega.qdocnow.preparation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QDocNumberFactoryTest {


	@Test
	public void should_add_prefix_when_demo() {
		// Given
		QDocNumberFactory factory = new QDocNumberFactory();

		// When
		QDocNumberFactory.QDocNumber number = factory.generate(true, "PJ/123");

		// Then
		assertThat(number.getValue()).isEqualTo("DEMO/PJ/123");
	}
}