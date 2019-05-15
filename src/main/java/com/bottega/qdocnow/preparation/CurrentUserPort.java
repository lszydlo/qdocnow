package com.bottega.qdocnow.preparation;

interface CurrentUserPort {
	/**
	 *
	 * @param role
	 * @throws RuntimeException
	 */
	void checkRole(String role);
}
