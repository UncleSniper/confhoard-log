package org.unclesniper.confhoard.logging;

import org.unclesniper.logging.LogSource;
import org.unclesniper.logging.LogMessage;
import org.unclesniper.logging.DefaultLogLevel;
import org.unclesniper.confhoard.core.StorageListener;

public class LoggingStorageListener extends AbstractLoggingListener implements StorageListener {

	private static final LogSource SLOT_LOADED_SOURCE = LogSource.in(LoggingStorageListener.class, "slotLoaded");

	private static final LogSource SLOT_PURGED_SOURCE = LogSource.in(LoggingStorageListener.class, "slotPurged");

	private static final LogSource STORAGE_LISTENER_FAILED_SOURCE
			= LogSource.in(LoggingStorageListener.class, "storageListenerFailed");

	public LoggingStorageListener() {}

	public LoggingStorageListener(LoggerProvider logger) {
		super(logger);
	}

	@Override
	public void slotLoaded(SlotLoadedStorageEvent event) {
		getEffectiveLogger(event::getRequestParameter).log(DefaultLogLevel.INFO,
				LoggingStorageListener.SLOT_LOADED_SOURCE, (LogMessage)new SlotLoadedStorageLogMessage(event));
	}

	@Override
	public void slotPurged(SlotPurgedStorageEvent event) {
		getEffectiveLogger(event::getRequestParameter).log(DefaultLogLevel.INFO,
				LoggingStorageListener.SLOT_PURGED_SOURCE, (LogMessage)new SlotPurgedStorageLogMessage(event));
	}

	@Override
	public void storageListenerFailed(StorageListenerFailedStorageEvent event) {
		getEffectiveLogger(event::getRequestParameter).log(DefaultLogLevel.ERROR,
				LoggingStorageListener.STORAGE_LISTENER_FAILED_SOURCE,
				(LogMessage)new StorageListenerFailedStorageLogMessage(event));
	}

}
