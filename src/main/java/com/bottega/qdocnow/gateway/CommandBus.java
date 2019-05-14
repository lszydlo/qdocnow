package com.bottega.qdocnow.gateway;

public interface CommandBus {
	void dispatch(Command command);
}
