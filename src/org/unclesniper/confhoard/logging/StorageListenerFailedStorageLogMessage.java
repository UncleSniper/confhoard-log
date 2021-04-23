package org.unclesniper.confhoard.logging;

import org.unclesniper.confhoard.core.StorageListener;
import org.unclesniper.logging.StringAndExceptionLogMessage;

public class StorageListenerFailedStorageLogMessage extends StringAndExceptionLogMessage {

	private final StorageListener.StorageListenerFailedStorageEvent event;

	public StorageListenerFailedStorageLogMessage(StorageListener.StorageListenerFailedStorageEvent event) {
		super(StorageListenerFailedStorageLogMessage.generateMessage(event), event.getException());
		this.event = event;
	}

	public StorageListener.StorageListenerFailedStorageEvent getEvent() {
		return event;
	}

	private static String generateMessage(StorageListener.StorageListenerFailedStorageEvent event) {
		if(event == null)
			throw new IllegalArgumentException("Event cannot be null");
		String message = event.getException().getMessage();
		return "Storage listener failed" + (message == null || message.length() == 0 ? "" : ": " + message);
	}

}
