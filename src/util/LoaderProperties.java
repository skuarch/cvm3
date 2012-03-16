package util;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class LoaderProperties {

    private static final Logger logger = Logger.getLogger(LoaderProperties.class);
    private String path = null;

    //==========================================================================
    public LoaderProperties(String path) {
        logger.debug("loading properties");
        this.path = path;
    } // end LoaderProperties

    //==========================================================================
    public Properties gerProperties() {

        if (path == null) {
            logger.error("path is null", new NullPointerException());
            return null;
        }

        Properties properties = null;
        FileInputStream fis = null;

        try {

            properties = new Properties();
            fis = new FileInputStream(path);
            properties.load(fis);

        } catch (Exception e) {
            logger.error(e);
        } finally {
            IOUtilities.closeInputStream(fis);
        }

        return properties;

    } // end getproperties
} // end class
