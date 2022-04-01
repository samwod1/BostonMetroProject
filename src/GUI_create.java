
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GUI_create extends Application {
    @FXML
    private Pane two_change;

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
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

        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
