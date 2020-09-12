package rough;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4jDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 Logger log=LogManager.getLogger(Log4jDemo.class);
	 
	 
	 log.info("I am the info messagge");
	 log.error("I am the error message");
	 log.fatal("I am the fatal message");
	 log.debug("I am the debug message");
	 log.warn("I am the warn message");
	
	
	}

}
