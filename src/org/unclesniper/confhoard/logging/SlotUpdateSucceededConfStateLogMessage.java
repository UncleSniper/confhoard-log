package org.unclesniper.confhoard.logging;

import org.unclesniper.logging.StringLogMessage;
import org.unclesniper.confhoard.core.ConfStateListener;

public class SlotUpdateSucceededConfStateLogMessage extends StringLogMessage {

	private final ConfStateListener.SlotUpdateSucceededStateEvent event;

	public SlotUpdateSucceededConfStateLogMessage(ConfStateListener.SlotUpdateSucceededStateEvent event) {
		super(SlotUpdateSucceededConfStateLogMessage.generateMessage(event));
		this.event = event;
	}

	public ConfStateListener.SlotUpdateSucceededStateEvent getEvent() {
		return event;
	}

	private static String generateMessage(ConfStateListener.SlotUpdateSucceededStateEvent event) {
		if(event == null)
			throw new IllegalArgumentException("Event cannot be null");
		StringBuilder builder = new StringBuilder();
		builder.append("Slot '");
		builder.append(event.getSlot().getKey());
		builder.append("' updated");
		LoggingConfStateListener.appendCredentials(builder, event.getCredentials());
		return builder.toString();
	}

}
