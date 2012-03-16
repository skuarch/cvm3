package common;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.log4j.Logger;
import util.PropertieUtilities;

/**
 *
 * @author skuarch
 */
public class ThreadCreator implements Runnable {

    private static final Logger logger = Logger.getLogger(ThreadCreator.class);
    private int scheduletask = 0;
    private Timer timer = null;
    private Files files = null;
    private String path = null;
    int join = 0;

    //==========================================================================
    public ThreadCreator() {

        timer = new Timer();
        files = new Files();
        path = PropertieUtilities.getStringPropertie("path.files");
        join = PropertieUtilities.getIntPropertie("thread.join");
        scheduletask = PropertieUtilities.getIntPropertie("schedule.task");

    } // end Proccessor    

    //==========================================================================
    @Override
    public void run() {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                timer.schedule(new TimerTask() {

                    //==========================================================
                    @Override
                    public void run() {

                        File[] arrayFiles = null;

                        try {

                            arrayFiles = files.getFiles(path);                            
logger.debug("inicio");
                            for (int i = 0; i < arrayFiles.length; i++) {

                                Thread thread = new Thread(new ProccessFile(arrayFiles[i]));
                                thread.start();
                                thread.join(join);
                                thread.setName("proccessFile:" + arrayFiles[i].getName());
                                
                            }
logger.debug("termino");
                            arrayFiles = null;

                        } catch (Exception e) {
                            logger.error("run", e);
                        } finally {
                            arrayFiles = null;
                            //files = null;
                        }
                    }
                }, 0, scheduletask);
            }
        });

        t.start();
        t.setName("Proccessor");

    } // end run
}
