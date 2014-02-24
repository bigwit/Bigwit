package com.bigwit.services.config;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/*
 * обеспечивает работу с заданными конфигурациями
 * в формате xml.
 * 
 * типа ConfigHelper
 * 
 */
public class ConfigHelper {
	
	private static Logger log = Logger.getLogger(ConfigHelper.class.getName());
	
	private static final String DEFAULT_CONFIGURATION_FILE = "../config/config/server/config.xml";
	private static String DEFAULT_DATABASE_CONFIG_FILE = null;
	
	private static Document document = null;
	
	static {
		File configSource = new File(DEFAULT_CONFIGURATION_FILE);
		if(!configSource.exists()) {
			log.warning("File configuration " + configSource.getAbsolutePath() + " not found");
		} else {
			try {
				DocumentBuilderFactory docBuildFact = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docBuildFact.newDocumentBuilder();
				document = docBuilder.parse(configSource);
			} catch (Exception e) {
				log.warning("PARSING ERROR. NOT VALIDATION CONFIGURATION.");
				e.printStackTrace();
			}
		}
	}
	
}
