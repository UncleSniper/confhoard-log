package org.unclesniper.confhoard.logging;

import java.util.function.Function;
import org.unclesniper.logging.Logger;

public abstract class AbstractLoggingListener {

	private LoggerProvider logger;

	private Logger cachedLogger;

	private boolean cacheLogger;

	public AbstractLoggingListener() {}

	public AbstractLoggingListener(LoggerProvider logger) {
		this.logger = logger;
	}

	public LoggerProvider getLogger() {
		return logger;
	}

	public void setLogger(LoggerProvider logger) {
		this.logger = logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger == null ? null : new IdentityLoggerProvider(logger);
	}

	public void setLogger(String parameter) {
		logger = parameter == null ? null : new RequestParameterLoggerProvider(parameter);
	}

	public boolean isCacheLogger() {
		return cacheLogger;
	}

	public void setCacheLogger(boolean cacheLogger) {
		this.cacheLogger = cacheLogger;
	}

	protected Logger getEffectiveLogger(Function<String, Object> requestParameters) {
		if(cachedLogger != null)
			return cachedLogger;
		if(logger == null)
			throw new IllegalStateException("No logger provider has been configured");
		Logger c = logger.getLogger(requestParameters);
		if(c == null)
			throw new IllegalStateException("Logger provider did not provide a logger");
		if(cacheLogger)
			cachedLogger = c;
		return c;
	}

}
