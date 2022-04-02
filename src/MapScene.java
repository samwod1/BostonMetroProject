

 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.fxml.FXMLLoader;
 import javafx.fxml.Initializable;
 import javafx.scene.Node;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
 import javafx.stage.Stage;


 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.net.URL;
 import java.util.ResourceBundle;


 /**
  *
  * Constructor for displays map image, Make sure fxml file uses absolute path for image
  * couldnt get the normal source one to work. (May have to update yourself)
  */
 public class MapScene implements Initializable {
    private Stage stage;

    //private double zoom;

    @FXML
    ImageView subwayImg;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
     //   zoom = 1;
    }

    /**
    public void zoomIn(){
        zoom += 0.2;
        subwayImg.setZ(zoom);
    }
     */

    /**
     * Switches back to main
     *
     * @param event
     * @throws IOException
     */
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
