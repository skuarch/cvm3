package common;

import java.io.File;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class Files {

    private static final Logger logger = Logger.getLogger(Files.class);

    //==========================================================================
    public Files() {
    } // end Files

    //==========================================================================
    public File[] getFiles(String path) {

        if (path == null || path.length() < 1) {
            logger.error("path is null", new NullPointerException());
            return null;
        }

        File file = null;
        File[] files = null;

        try {

            file = new File(path);
            files = file.listFiles();

        } catch (Exception e) {
            logger.error(e);
        }

        return files;
    } // end getFiles
    
} // end class
