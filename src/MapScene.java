package src;

 import javafx.event.ActionEvent;
 import javafx.fxml.FXMLLoader;
 import javafx.fxml.Initializable;
 import javafx.scene.Node;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.stage.Stage;
 import java.io.IOException;
 import java.net.URL;
 import java.util.ResourceBundle;


public class MapScene implements Initializable {
    private Stage stage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void switchToMain(ActionEvent event) throws IOException{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GUI_Main.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene mapScene = new Scene(root);
            this.stage.setScene(mapScene);
            stage.show();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
