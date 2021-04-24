package org.unclesniper.confhoard.logging;

import org.unclesniper.logging.LogSource;
import org.unclesniper.logging.LogMessage;
import org.unclesniper.logging.DefaultLogLevel;
import org.unclesniper.confhoard.core.listener.ConfStateReconfigurationListener;

public class LoggingConfStateReconfigurationListener extends AbstractLoggingListener
		implements ConfStateReconfigurationListener {

	private static final LogSource CONFSTATE_RECONFIGURED_SOURCE
			= LogSource.in(LoggingConfStateReconfigurationListener.class, "confStateReconfigured");

	public LoggingConfStateReconfigurationListener() {}

	public LoggingConfStateReconfigurationListener(LoggerProvider logger) {
		super(logger);
	}

	@Override
	public void confStateReconfigured(ReconfigurationEvent event) {
		getEffectiveLogger(event::getRequestParameter).log(DefaultLogLevel.INFO,
				LoggingConfStateReconfigurationListener.CONFSTATE_RECONFIGURED_SOURCE,
				(LogMessage)new ConfStateReconfiguredConfStateReconfigurationLogMessage(event));
	}

}
