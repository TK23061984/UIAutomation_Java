package common;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

	private static String _fileName = null;
	static Logger logger = null;
	
	public Log(String fileName)
	{
		_fileName = fileName;
		logger = Logger.getLogger(_fileName);
       PropertyConfigurator.configure("log4j.properties");
	}
	
    public void info(String message)
    {
    	logger.info(message);    	
    }
    
    public void warn(String message)
    {
    	logger.warn(message);    	
    }
    
    public void error(String message)
    {
    	logger.error(message);    	
    }
    
    public void fatal(String message)
    {    	
    	logger.fatal(message);
    }
    
}
