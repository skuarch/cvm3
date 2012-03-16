package util;

import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class PropertieUtilities {

    private static final Logger logger = Logger.getLogger(PropertieUtilities.class);
    private static final String PATH = "configuration/configuration.properties";
    private static final Properties properties = new LoaderProperties(PATH).gerProperties();

    //==========================================================================
    public static String getStringPropertie(String name) {

        String propertie = null;

        try {

            propertie = properties.getProperty(name);

        } catch (Exception e) {
            logger.error("getStringProperties", e);
        }

        return propertie;
    } // end getPropertie

    //==========================================================================
    public static int getIntPropertie(String name) {

        int num = 0;

        try {

            num = Integer.parseInt(properties.getProperty(name));

        } catch (Exception e) {
            logger.error("getIntProperties", e);
        }

        return num;
    } // end getPropertie
} // end class