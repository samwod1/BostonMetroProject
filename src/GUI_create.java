

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;

public class GUI_create extends Application {

    private Stage stage;
    private Scene scene;

    public static final CountDownLatch latch = new CountDownLatch(1);
    public static GUI_create runGUI = null;

    public static GUI_create waitForStartUpTest() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return runGUI;
    }

    public static void setRunGUI(GUI_create startUpTest0) {
        runGUI = startUpTest0;
        latch.countDown();
    }

    public GUI_create() {
        setRunGUI(this);
    }

    /**
     *
     * Loads and sets up the frame and GUI. Just the driver for everything GUI. Can be linked to another
     * driver in a special way like in the dirver class. needs to be on own. no eventlisteners in here.
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            this.stage = primaryStage;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI_Main.fxml"));
            Parent root = loader.load();
            GUI_eventlisteners startEvents = loader.getController();
            primaryStage.setTitle("Boston Subway");
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("bstnsoobway.css").toExternalForm();
            scene.getStylesheets().add(css);
            // primaryStage.setFullScreen(true);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}

