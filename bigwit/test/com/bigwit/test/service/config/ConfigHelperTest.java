package com.bigwit.test.service.config;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.bigwit.common.exception.BigwitRuntimeConfigurationException;
import com.bigwit.services.config.BigwitConfig;
import com.bigwit.services.config.ConfigHelper;

public class ConfigHelperTest {

	public static void main(String[] args) {
		try {
			BigwitConfig bc = ConfigHelper.initDBConfig();
			
		} catch (BigwitRuntimeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
