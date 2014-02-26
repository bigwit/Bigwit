package com.bigwit.services.config;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.bigwit.common.exception.BigwitRuntimeConfigurationException;

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
				document.getDocumentElement().normalize();
				
				NodeList nodes = document.getElementsByTagName("config-db");
				DEFAULT_DATABASE_CONFIG_FILE = nodes.item(nodes.getLength() - 1).getTextContent();
				log.info("Using db configuration \"" + DEFAULT_DATABASE_CONFIG_FILE + "\" file");
			} catch (Exception e) {
				log.warning("PARSING ERROR. NOT VALIDATION CONFIGURATION.");
				e.printStackTrace();
			}
		}
	}
	
	public static BigwitConfig initDBConfig() throws BigwitRuntimeConfigurationException, SAXException, IOException, ParserConfigurationException {
		if(ConfigHelper.DEFAULT_DATABASE_CONFIG_FILE == null) {
			throw new BigwitRuntimeConfigurationException("DB Configuration is not initialize");
		}
		DocumentBuilderFactory docBuildFact = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuildFact.newDocumentBuilder();
		log.info("Search config file " + new File(DEFAULT_DATABASE_CONFIG_FILE).getAbsolutePath() + " ...");
		document = docBuilder.parse("../config/config/server/" + DEFAULT_DATABASE_CONFIG_FILE);
		document.getDocumentElement().normalize();
		
		NodeList nodes = document.getElementsByTagName("login");
		String login = nodes.item(0).getTextContent();
		nodes = document.getElementsByTagName("password");
		String passwd = nodes.item(0).getTextContent();
		nodes = document.getElementsByTagName("db-name");
		String dbName = nodes.item(0).getTextContent();
		nodes = document.getElementsByTagName("db-port");
		String dbport = nodes.item(0).getTextContent();
		nodes = document.getElementsByTagName("db-domain");
		String hostname = nodes.item(0).getTextContent();
		return BigwitConfig.createDBConfiguration(hostname, dbport, login, passwd, dbName);
	}
	
}
