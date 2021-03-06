package org.unclesniper.confhoard.logging.resource;

import java.util.ResourceBundle;

public final class Resources {

	public static final String L10N_BUNDLE = Localization.getBundleFor(Resources.class, "confhoard-log");

	private Resources() {}

	public static ResourceBundle getBundle(Localization localization) {
		if(localization == null)
			localization = new Localization();
		return localization.getBundleFromDefaultOr(Resources.L10N_BUNDLE, Resources.class);
	}

}
