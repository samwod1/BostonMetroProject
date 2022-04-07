import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
//import org.junit.Test;
//import org.junit.jupiter.api.Test;

//import static org.junit.Assert.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This is the application which starts JavaFx.  It is controlled through the startJavaFx() method.
 */
class testGUI extends Application
{

    /** The lock that guarantees that only one JavaFX thread will be started. */
    private static final ReentrantLock LOCK = new ReentrantLock();

    /** Started flag. */
    private static AtomicBoolean started = new AtomicBoolean();

    /**
     * Start JavaFx.
     */
    public static void startJavaFx()
    {
        try
        {
            // Lock or wait.  This gives another call to this method time to finish
            // and release the lock before another one has a go
            LOCK.lock();

            if (!started.get())
            {
                // start the JavaFX application
                final ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.execute(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        testGUI.launch();
                    }
                });

                while (!started.get())
                {
                    Thread.yield();
                }
            }
        }
        finally
        {
            LOCK.unlock();
        }
    }

    /**
     * Launch.
     */
    protected static void launch()
    {
        Application.launch();
    }

    /**
     * An empty start method.
     *
     * @param stage The stage
     */
    @Override
    public void start(final Stage stage)
    {
        started.set(Boolean.TRUE);
    }
}
/**
public class testGUI extends Application {

    Platform.Startup();
    GUI_create gui_create;
    Driver driver = new Driver();
    GUI_eventlisteners gui = new GUI_eventlisteners();
    protected void setUp() {
        gui_create = new GUI_create();
    }

    // test method to add two values
    @Test
    public void testRoute() {
        String from = "OakGrove";
        String to = "Wellington";
        gui.finalRoute(from, to);
        ObservableList<String> obs = gui.getPath();
        assert(3, obs.size());

    }
}
*/