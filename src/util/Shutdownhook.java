package util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author skuarch
 */
public class Shutdownhook extends Thread {

    private static final Logger logger = Logger.getLogger(Shutdownhook.class);
    
    //==========================================================================
    public Shutdownhook(){
        PropertyConfigurator.configure("configuration/log4j.properties");
    } // end Shutdownhook
    
    //==========================================================================
    public void run(){
        logger.error("the application was stopped");
    } // end run

} // end class
