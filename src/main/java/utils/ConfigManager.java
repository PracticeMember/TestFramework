package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ConfigManager {
	private static final Logger log=LoggerFactory.getLogger(ConfigManager.class);
	
	private static final List<Properties>layers=new ArrayList<>();
	
	private ConfigManager() {}
	
	public static void load(String... files) {
		layers.clear();
		
		for(String file:files) {
			file=System.getProperty("user.dir")+file+".properties";
			Properties props=new Properties();
			try (FileInputStream fs=new FileInputStream(file)){
				props.load(fs);
				layers.add(props);
			} catch (IOException e) {
			   throw new RuntimeException("Unable to load "+file,e);
			} 
		}
		log.info("Config properties files are loaded");
	}
	
	public static String getProperty(String key) {
		for(int i=layers.size()-1; i>=0; i--) {
			String value=layers.get(i).getProperty(key);
			if(value!=null) {
				return value;
			}
			log.info("Couldn't find '{}' property in primary config,switching to common files",key);
		}
		return null;
	}
}
