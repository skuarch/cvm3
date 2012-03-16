package util;

import java.io.FileReader;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class IOUtilities {

    private static final Logger logger = Logger.getLogger(IOUtilities.class);

    //==========================================================================
    public static void closeInputStream(InputStream is) {

        try {

            if (is != null) {
                is.close();
            }
        } catch (Exception e) {
            logger.error(e);
        } finally {
            is = null;
        }

    } // end closeInputStream

    //==========================================================================
    public static void closeFileReader(FileReader fileReader) {

        try {

            if (fileReader != null) {
                fileReader.close();
            }

        } catch (Exception e) {
            logger.error(e);
        } finally {
            fileReader = null;
        }

    } // end closeFileReader

    //==========================================================================
    public static void closeLineNumberReader(LineNumberReader lineNumberReader) {

        try {

            if (lineNumberReader != null) {
                lineNumberReader.close();
            }

        } catch (Exception e) {
            logger.error(e);
        } finally {
            lineNumberReader = null;
        }

    } // end closeLineNumberReader
    
    //==========================================================================
    public static void closeScanner(Scanner scanner) {

        try {

            if (scanner != null) {
                scanner.close();
            }

        } catch (Exception e) {
            logger.error(e);
        } finally {
            scanner = null;
        }

    } // end closeLineNumberReader
} // end class
