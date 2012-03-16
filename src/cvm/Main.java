package cvm;

import common.ThreadCreator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import util.Shutdownhook;

/**
 *
 * @author skuarch
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    //==========================================================================
    public Main() {
    } // end Main

    //==========================================================================
    public static void main(String[] args) {
        PropertyConfigurator.configure("configuration/log4j.properties");
        Main.logger.info("** program start **");
        Runtime.getRuntime().addShutdownHook(new Shutdownhook());
        new Thread(new ThreadCreator()).start();
    } // end main    
} // end class
