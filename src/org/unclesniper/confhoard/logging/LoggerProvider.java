package org.unclesniper.confhoard.logging;

import java.util.function.Function;
import org.unclesniper.logging.Logger;

public interface LoggerProvider {

	Logger getLogger(Function<String, Object> requestParameters);

}
