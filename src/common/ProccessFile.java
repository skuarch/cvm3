package common;

import beans.Record;
import dao.DAO;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Scanner;
import org.apache.log4j.Logger;
import util.IOUtilities;

/**
 *
 * @author skuarch
 */
public class ProccessFile extends Thread {

    private static final Logger logger = Logger.getLogger(ProccessFile.class);
    private File file = null;
    private Scanner scanner = null;
    private Record record = null;
    private int nLines = 0;
    private int count = 0;

    //==========================================================================
    public ProccessFile(File file) throws Exception {
        this.file = file;
        this.record = new Record();
        nLines = getNumLineas(file);
    } // end ProccessFile

    //==========================================================================
    @Override
    public void run() {

        //logger.debug("proccessing file " + file.getName() + " numLines " + nLines);

        try {

            //validation of file
            if (!file.canWrite()) {
                return;
            }

            if (!validateName(file)) {
                return;
            }

            if (!validateNumLines(file)) {
                return;
            }

            scanner = new Scanner(file);
            scanner.useDelimiter(";\\s*");
            scanner.nextLine();
            scanner.nextLine();

            while (scanner.hasNext()) {

                //recordType                 
                record.setRecordType(scanner.next());
                if (!validateRecordType(record.getRecordType())) {
                    file.delete();
                    break;
                }

                record.setSourceIpAddress(scanner.next().trim());
                record.setDestinationIpAddress(scanner.next().trim());
                record.setConnectionId(scanner.next());
                record.setCalling(scanner.next());
                record.setSubAddress(scanner.next());

                //disconnect_text
                record.setDisconnectText(scanner.next());
                if (!validateDisconnectText(record.getDisconnectText())) {
                    scanner.nextLine();
                    continue;
                }
                record.setDisconnectText(cleanDisconnectText(record.getDisconnectText()));

                //dates
                record.setConnectTime(scanner.next());
                record.setConnectTime(formatDates(record.getConnectTime()));
                record.setDisconnectTime(scanner.next());
                record.setDisconnectTime(formatDates(record.getDisconnectTime()));

                record.setOrigin(scanner.next());
                record.setChargedUnits(scanner.next());
                record.setCallType(scanner.next());
                record.setTransmitPackets(scanner.next());
                record.setTransmitBytes(scanner.next());
                record.setReceivePackets(scanner.next());
                record.setReceiveBytes(scanner.next());

                if (record.getRecordType().equals("0")) {

                    //telephony
                    record.setTransmitDuration(scanner.next());
                    record.setSpeechDuration(scanner.next());
                    scanner.next();
                    record.setCoderRate(scanner.next());
                    record.setNoiseLevel(scanner.next());
                    record.setAcomLevel(scanner.next());
                    scanner.next();
                    scanner.next();
                    record.setPeerID(scanner.next());
                    scanner.next();
                    record.setLogicalIfIndex(scanner.next());

                } else {

                    //voIP
                    scanner.next();
                    record.setCoderRate(scanner.next());
                    scanner.next();
                    scanner.next();
                    record.setRemoteIpAddress(scanner.next());
                    scanner.next();
                    record.setRoundTripDelay(scanner.next());
                    record.setSelectedQos(scanner.next());
                    scanner.next();
                    scanner.next();
                    scanner.next();
                    record.setLostPackets(scanner.next());
                    scanner.next();
                    scanner.next();
                    scanner.next();
                    scanner.next();
                    scanner.next();
                    scanner.next();
                    scanner.next();
                    scanner.next();
                    scanner.next();
                    record.setHiWaterDelay(scanner.next());
                    record.setLoWaterDelay(scanner.next());
                    record.setReceiveDelay(scanner.next());
                    record.setPeerID(scanner.next());
                    scanner.next();
                    record.setLogicalIfIndex(scanner.next());

                }

                //save record
                new DAO().create(record);

                //next line
                scanner.nextLine();

                // break because the file is rare
                if (count == nLines - 2) {
                    break;
                }

                count++;

            } // end while

        } catch (Exception e) {
            logger.error("run", e);
            e.printStackTrace();
        } finally {
            file = null;
            IOUtilities.closeScanner(scanner);
        }

    } // end run

    //==========================================================================
    private void cleanUp() {

        try {
            IOUtilities.closeScanner(scanner);
            file = null;
            count = 0;
            nLines = 0;
        } catch (Exception e) {
            logger.error(e);
        }

    } // end cleanup

    //==========================================================================
    private synchronized boolean validateName(File file) {

        String name = null;
        boolean flag = true;

        try {

            name = file.getName();

            if (name.equalsIgnoreCase("poll.info")
                    || name.equalsIgnoreCase("router.dat")
                    || name.equalsIgnoreCase("Sessior")
                    || name.equalsIgnoreCase("Session")
                    || name.equalsIgnoreCase("Cancel")
                    || name.equalsIgnoreCase("README.TXT")) {
                flag = false;
            }

        } catch (Exception e) {
            logger.error(e);
        }

        return flag;

    } // end validatename    

    //==========================================================================
    private synchronized boolean validateNumLines(File file) {

        boolean flag = true;

        int numLines = 0;

        try {

            numLines = getNumLineas(file);

            if (numLines < 3) {
                flag = false;
            }


        } catch (Exception e) {
            logger.error(e);
        }

        return flag;

    } // end calidateNumLines

    //==========================================================================
    public synchronized boolean validateRecordType(String recordType) {

        boolean flag = false;

        try {

            if (recordType.equals("6") || recordType.equals("11") || recordType.equals("7") || recordType.equals("8")) {
                return false;
            }

            if (recordType.equals("1") || recordType.equals("0")) {
                return true;
            }

            if (recordType.equalsIgnoreCase("") || recordType.equalsIgnoreCase(" ") || recordType.equals(null)) {
                return false;
            }

        } catch (Exception e) {
            logger.error(e);
        }

        return flag;

    } // end validateRecordType

    //==========================================================================
    public synchronized boolean validateDisconnectText(String disconnectText) {

        boolean flag = true;

        try {

            if (disconnectText == null || disconnectText.length() < 1) {
                return false;
            }

            if (disconnectText.contains("0x")) {
                flag = false;
            }

        } catch (Exception e) {
            logger.error(e);
        }

        return flag;

    } // end validateDisconnectText

    //==========================================================================
    private synchronized String cleanDisconnectText(String disconnectText) {

        String dt = "";

        try {

            for (int i = 0; i <= disconnectText.length() - 1; i++) {

                if (disconnectText.charAt(i) == '.' || disconnectText.charAt(i) == '(') {
                    //salir del for
                    break;
                }
                dt += disconnectText.charAt(i);
            }

        } catch (Exception e) {
            logger.error(e);
        }

        return dt;

    } // end cleanDisconnectText

    //==========================================================================
    public synchronized String formatDates(String date) {

        String formatDate = null;
        String year = null;
        String mounth = null;
        String day = null;
        String hourMinuteSecond = null;

        try {

            if (date.length() > 8) {

                year = date.substring(6, 10);
                mounth = date.substring(0, 2);
                day = date.substring(3, 5);
                hourMinuteSecond = date.substring(11, 19);

                formatDate = year + "-" + mounth + "-" + day + " " + hourMinuteSecond;

            } else {
                formatDate = "0000-00-00 00:00:00";
            }

        } catch (Exception e) {
            logger.error(e);
        }

        return formatDate;
    } // end formatDates

    //==========================================================================
    private synchronized int getNumLineas(File file) {

        LineNumberReader lineNumberReader = null;
        FileReader fileReader = null;
        int numLines = 0;

        try {

            fileReader = new FileReader(file);
            lineNumberReader = new LineNumberReader(fileReader);
            lineNumberReader.skip(Long.MAX_VALUE);
            numLines = lineNumberReader.getLineNumber();

        } catch (Exception e) {
            logger.error(e);
        } finally {
            IOUtilities.closeFileReader(fileReader);
            IOUtilities.closeLineNumberReader(lineNumberReader);
        }

        return numLines;
    } // end getNumLines

    //==========================================================================
    @Override
    protected void finalize() throws Throwable {
        try {

            cleanUp();

        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        } finally {
            super.finalize();
        }
    } // end finalize
} // end class
