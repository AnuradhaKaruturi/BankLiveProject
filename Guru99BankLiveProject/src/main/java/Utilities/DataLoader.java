package Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataLoader {

	private Properties properties;
	private final String propertyFilePath= "D:\\Selenium WorkSpace\\Guru99BankLiveProject\\src\\main\\java\\data.property";
	public DataLoader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}	
		
		
	}
	
	public String getUsername() {
		return properties.getProperty("username");
	}
	public String getPassword() {
		
		return properties.getProperty("password");
	}
	
	public String getBrowserName() {
		return properties.getProperty("browserName");
	}
	public String getUrl() {
		return properties.getProperty("url");
	}
}
