package org.unclesniper.confhoard.logging;

import org.unclesniper.logging.LogSource;
import org.unclesniper.logging.LogMessage;
import org.unclesniper.logging.DefaultLogLevel;
import org.unclesniper.confhoard.core.ConfStateListener;
import org.unclesniper.confhoard.core.security.Credentials;

public class LoggingConfStateListener extends AbstractLoggingListener implements ConfStateListener {

	private static final LogSource SLOT_UPDATE_SUCCEEDED_SOURCE
			= LogSource.in(LoggingConfStateListener.class, "slotUpdateSucceeded");

	private static final LogSource SLOT_UPDATE_FAILED_SOURCE
			= LogSource.in(LoggingConfStateListener.class, "slotUpdateFailed");

	private static final LogSource CONFSTATE_LISTENER_FAILED_SOURCE
			= LogSource.in(LoggingConfStateListener.class, "confStateListenerFailed");

	public LoggingConfStateListener() {}

	public LoggingConfStateListener(LoggerProvider logger) {
		super(logger);
	}

	@Override
	public void slotUpdateSucceeded(SlotUpdateSucceededStateEvent event) {
		getEffectiveLogger(event::getRequestParameter).log(DefaultLogLevel.INFO,
				LoggingConfStateListener.SLOT_UPDATE_SUCCEEDED_SOURCE,
				(LogMessage)new SlotUpdateSucceededConfStateLogMessage(event));
	}

	@Override
	public void slotUpdateFailed(SlotUpdateFailedStateEvent event) {
		getEffectiveLogger(event::getRequestParameter).log(DefaultLogLevel.ERROR,
				LoggingConfStateListener.SLOT_UPDATE_FAILED_SOURCE,
				(LogMessage)new SlotUpdateFailedConfStateLogMessage(event));
	}

	@Override
	public void confStateListenerFailed(ConfStateListenerFailedStateEvent event) {
		getEffectiveLogger(event::getRequestParameter).log(DefaultLogLevel.ERROR,
				LoggingConfStateListener.CONFSTATE_LISTENER_FAILED_SOURCE,
				(LogMessage)new ConfStateListenerFailedConfStateLogMessage(event));
	}

	public static void appendCredentials(StringBuilder sink, Credentials credentials) {
		if(sink == null)
			throw new IllegalArgumentException("Sink cannot be null");
		if(credentials == null)
			return;
		sink.append(" by ");
		sink.append(credentials.toString());
	}

}
