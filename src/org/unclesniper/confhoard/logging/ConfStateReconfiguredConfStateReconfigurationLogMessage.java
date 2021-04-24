package org.unclesniper.confhoard.logging;

import org.unclesniper.logging.StringLogMessage;
import org.unclesniper.confhoard.core.listener.ConfStateReconfigurationListener;

public class ConfStateReconfiguredConfStateReconfigurationLogMessage extends StringLogMessage {

	private final ConfStateReconfigurationListener.ReconfigurationEvent event;

	public ConfStateReconfiguredConfStateReconfigurationLogMessage(
			ConfStateReconfigurationListener.ReconfigurationEvent event) {
		super(ConfStateReconfiguredConfStateReconfigurationLogMessage.generateMessage(event));
		this.event = event;
	}

	public ConfStateReconfigurationListener.ReconfigurationEvent getEvent() {
		return event;
	}

	private static String generateMessage(ConfStateReconfigurationListener.ReconfigurationEvent event) {
		if(event == null)
			throw new IllegalArgumentException("Event cannot be null");
		StringBuilder builder = new StringBuilder();
		builder.append("ConfState reconfigured");
		LoggingConfStateListener.appendCredentials(builder, event.getCredentials());
		return builder.toString();
	}

}
