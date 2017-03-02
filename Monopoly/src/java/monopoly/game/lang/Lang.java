package monopoly.game.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Lang {
	public static final String LANG_FOLDER = "lang";
	public static final String BOARD = "board";
	public static final String SQUARE = BOARD+".square";
	public static final String STREET = SQUARE+".street";
	public static final String TRANSPORT = SQUARE+".transport";
	public static final String PUBLIC_SERVICE = SQUARE+".public_service";
	private static Properties properties = new Properties();

	public static void init(String lang) throws IOException {
		lang=lang+".lang";
		InputStream propertiesFile = null;
		try {
			propertiesFile = new FileInputStream(LANG_FOLDER +File.separator+ lang);
			properties.load(propertiesFile);
		} catch (IOException e) {
			propertiesFile= ClassLoader.getSystemResourceAsStream(LANG_FOLDER +"/"+ lang);
			if(propertiesFile!=null){
				try {
					properties.load(propertiesFile);
				} catch (IOException e1) {
					properties.putAll(defaultProperties());
				}
				propertiesFile.close();
			}else{
				properties.putAll(defaultProperties());
			}
		}finally {
			if (propertiesFile != null) {
				propertiesFile.close();
			}
		}

	}
	

	public static String getString(String key){
		return properties.getProperty(key);
	}
	public static int getInt(String key){
		try {
			return Integer.parseInt(properties.getProperty(key));
		} catch (Exception e) {
			return 0;
		}
		
	}

	private static Properties defaultProperties(){
		 Properties defaultProperties = new Properties();
		 defaultProperties.put("", "");
		 return defaultProperties;
				
		
	}
}
