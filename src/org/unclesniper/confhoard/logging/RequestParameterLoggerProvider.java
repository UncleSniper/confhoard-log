package org.unclesniper.confhoard.logging;

import java.util.function.Function;
import org.unclesniper.logging.Logger;

public class RequestParameterLoggerProvider implements LoggerProvider {

	public static final String DEFAULT_PARAMETER = "org.unclesniper.confhoard.logger";

	private String parameter;

	public RequestParameterLoggerProvider() {}

	public RequestParameterLoggerProvider(String parameter) {
		this.parameter = parameter;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public Logger getLogger(Function<String, Object> requestParameters) {
		if(requestParameters == null)
			return null;
		String param = parameter;
		if(param == null)
			param = RequestParameterLoggerProvider.DEFAULT_PARAMETER;
		Object obj = requestParameters.apply(param);
		return obj instanceof Logger ? (Logger)obj : null;
	}

}
