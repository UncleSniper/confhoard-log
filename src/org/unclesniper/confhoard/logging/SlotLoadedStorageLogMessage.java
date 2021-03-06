package org.unclesniper.confhoard.logging;

import org.unclesniper.confhoard.core.Slot;
import org.unclesniper.logging.StringLogMessage;
import org.unclesniper.confhoard.core.StorageListener;

public class SlotLoadedStorageLogMessage extends StringLogMessage {

	private final StorageListener.SlotLoadedStorageEvent event;

	public SlotLoadedStorageLogMessage(StorageListener.SlotLoadedStorageEvent event) {
		super(SlotLoadedStorageLogMessage.generateMessage(event));
		this.event = event;
	}

	public StorageListener.SlotLoadedStorageEvent getEvent() {
		return event;
	}

	private static String generateMessage(StorageListener.SlotLoadedStorageEvent event) {
		if(event == null)
			throw new IllegalArgumentException("Event cannot be null");
		StringBuilder builder = new StringBuilder();
		Slot slot = event.getSlot();
		boolean active = slot.getFragment() != null;
		builder.append("Loaded slot '");
		builder.append(slot.getKey());
		builder.append("' from storage (");
		builder.append(String.valueOf(event.getFragmentCount() - (active ? 0 : 1)));
		builder.append(" fragments, ");
		builder.append(active ? "one" : "none");
		builder.append(" active)");
		return builder.toString();
	}

}
