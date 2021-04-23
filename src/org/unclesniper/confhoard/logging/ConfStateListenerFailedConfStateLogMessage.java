package org.unclesniper.confhoard.logging;

import org.unclesniper.confhoard.core.ConfStateListener;
import org.unclesniper.logging.StringAndExceptionLogMessage;

public class ConfStateListenerFailedConfStateLogMessage extends StringAndExceptionLogMessage {

	private final ConfStateListener.ConfStateListenerFailedStateEvent event;

	public ConfStateListenerFailedConfStateLogMessage(ConfStateListener.ConfStateListenerFailedStateEvent event) {
		super(ConfStateListenerFailedConfStateLogMessage.generateMessage(event), event.getException());
		this.event = event;
	}

	public ConfStateListener.ConfStateListenerFailedStateEvent getEvent() {
		return event;
	}

	private static String generateMessage(ConfStateListener.ConfStateListenerFailedStateEvent event) {
		if(event == null)
			throw new IllegalArgumentException("Event cannot be null");
		StringBuilder builder = new StringBuilder();
		builder.append("ConfState listener failed");
		String message = event.getException().getMessage();
		if(message != null && message.length() > 0) {
			builder.append(": ");
			builder.append(message);
		}
		return builder.toString();
	}

}
