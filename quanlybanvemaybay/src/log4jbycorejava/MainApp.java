package log4jbycorejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MainApp {
	final static Logger logger = Logger.getLogger(MainApp.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure("log4j.properties");
		
		  logger.info("Log4JCoreJavaSample by Info");
		 
		  logger.debug("Log4JCoreJavaSample by Debug");
		 logger.error("eee");
		  logger.warn("wwwww");
	}

}
