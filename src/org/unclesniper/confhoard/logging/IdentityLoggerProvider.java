package org.unclesniper.confhoard.logging;

import java.util.function.Function;
import org.unclesniper.logging.Logger;

public class IdentityLoggerProvider implements LoggerProvider {

	private Logger logger;

	public IdentityLoggerProvider() {}

	public IdentityLoggerProvider(Logger logger) {
		this.logger = logger;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Override
	public Logger getLogger(Function<String, Object> requestParameters) {
		return logger;
	}

}
