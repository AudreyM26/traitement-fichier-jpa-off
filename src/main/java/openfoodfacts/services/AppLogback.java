package openfoodfacts.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AppLogback {

	private static final Logger LOG = LoggerFactory.getLogger(AppLogback.class);

	public void executer(String param) {
		LOG.debug("Traitement: param = {}", param);
	}
}

