package org.unclesniper.confhoard.logging;

import org.unclesniper.logging.StringLogMessage;
import org.unclesniper.confhoard.core.StorageListener;

public class SlotPurgedStorageLogMessage extends StringLogMessage {

	private final StorageListener.SlotPurgedStorageEvent event;

	public SlotPurgedStorageLogMessage(StorageListener.SlotPurgedStorageEvent event) {
		super(SlotPurgedStorageLogMessage.generateMessage(event));
		this.event = event;
	}

	public StorageListener.SlotPurgedStorageEvent getEvent() {
		return event;
	}

	private static String generateMessage(StorageListener.SlotPurgedStorageEvent event) {
		if(event == null)
			throw new IllegalArgumentException("Event cannot be null");
		StringBuilder builder = new StringBuilder();
		builder.append("Purged slot '");
		builder.append(event.getSlot().getKey());
		builder.append("' from storage (");
		builder.append(String.valueOf(event.getFragmentCount()));
		builder.append(" fragments)");
		return builder.toString();
	}

}
