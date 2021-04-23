package org.unclesniper.confhoard.logging;

import org.unclesniper.confhoard.core.ConfStateListener;
import org.unclesniper.logging.StringAndExceptionLogMessage;

public class SlotUpdateFailedConfStateLogMessage extends StringAndExceptionLogMessage {

	private final ConfStateListener.SlotUpdateFailedStateEvent event;

	public SlotUpdateFailedConfStateLogMessage(ConfStateListener.SlotUpdateFailedStateEvent event) {
		super(SlotUpdateFailedConfStateLogMessage.generateMessage(event), event.getException());
		this.event = event;
	}

	public ConfStateListener.SlotUpdateFailedStateEvent getEvent() {
		return event;
	}

	private static String generateMessage(ConfStateListener.SlotUpdateFailedStateEvent event) {
		if(event == null)
			throw new IllegalArgumentException("Event cannot be null");
		StringBuilder builder = new StringBuilder();
		builder.append("Update of slot '");
		builder.append(event.getSlot().getKey());
		builder.append('\'');
		LoggingConfStateListener.appendCredentials(builder, event.getCredentials());
		builder.append(" failed");
		String message = event.getException().getMessage();
		if(message != null && message.length() > 0) {
			builder.append(": ");
			builder.append(message);
		}
		return builder.toString();
	}

}
