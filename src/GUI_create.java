package src;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI_create extends Application implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    String Start;
    String End;


    /**
     * Set Up Listviews and Choice boxes
     */
    @FXML
    private ListView<String> fromListView;
    @FXML
    private ListView<String> toListView;
    @FXML
    private ListView<String> resultingPath;
    @FXML
    private ChoiceBox<String> fromLineDropDown;
    @FXML
    private ChoiceBox<String> toLineDropdown;
    /**
     * To setup buttons and text field
     */
    @FXML
    private TextField fromtxt;
    @FXML
    private TextField totxt;
    @FXML
    private Pane two_change;
    @FXML
    private Pane one_change;
    /**
     * Next few is for no changes labels and lines. nc = no changes
     */
    @FXML
    private Pane no_change;
    @FXML
    private Label nclinename;
    @FXML
    private Label ncstartstn;
    @FXML
    private Label ncstops;
    @FXML
    private Label ncendstn;
    @FXML
    private Line ncline;
    /**
     * Next few is for one change labels and lines. oc = one change
     */
    @FXML
    private Label oclinename1;
    @FXML
    private Label oclinename2;
    @FXML
    private Label ocstartstn;
    @FXML
    private Label ocmiddlestn2;
    @FXML
    private Label ocstops;
    @FXML
    private Label ocstops2;
    @FXML
    private Label ocmiddlestn;
    @FXML
    private Label ocendstn;
    @FXML
    private Line ocline1;
    @FXML
    private Line ocline2;
    /**
     * Next few is for two changes labels and lines. tc = two changes
     */
    @FXML
    private Label tclinename1;
    @FXML
    private Label twoclinename2;
    @FXML
    private Label tcstart;
    @FXML
    private Label tcend;
    @FXML
    private Label tcstop1;
    @FXML
    private Label tcstop2;
    @FXML
    private Label tcmiddlestn1;
    @FXML
    private Label tcmiddlestn2;
    @FXML
    private Label tclinename3;
    @FXML
    private Line tcline1;
    @FXML
    private Line tcline2;
    @FXML
    private QuadCurve tcline3;

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI_Main.fxml"));
            Parent root = loader.load();
            // GUI_eventlisteners startEvents = loader.getController();
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

    public void submitbtn(ActionEvent event){
        try{
            Start = fromtxt.getText();
            End = totxt.getText();
            setTwo_change(Start,"Charring Cross", "Haymarket", End, "Red", "Blue", "Yellow", 4, 6);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    String[] letters = {"e","b","r"};
    String[] lines = {"Red", "RedA", "RedB", "Blue", "Orange", "Mattapan",
                        "Green", "GreenA", "GreenB", "GreenC", "GreenD", "GreenE"};


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){


        fromListView.getItems().addAll(letters);
        toListView.getItems().addAll(letters);
        resultingPath.getItems().addAll(letters);
    }

    public void switchToMap(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("map.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene mapScene = new Scene(root);
        stage.setScene(mapScene);
        stage.show();
    }

    public void switchToMain(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("GUI_Main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene mapScene = new Scene(root);
        stage.setScene(mapScene);
        stage.show();
    }


    /**
     * Will Display A line if theres no changes
     *
     * @param start
     * @param end
     * @param line
     * @param stops
     */
    public void setNo_change(String start, String end, Array line, int stops){
        (no_change).setVisible(true);
        (one_change).setVisible(false);
        (two_change).setVisible(false);
        nclinename.setText(line + " Line");
        ncstartstn.setText(start);
        ncstops.setText(stops + " stops");
        ncendstn.setText(end);
        ncline.setStroke(Color.RED);
        // find find start to end
    }

    /**
     * Is meant to display the route with one change
     *
     * @param start
     * @param middle
     * @param end
     * @param line
     * @param line2
     * @param stops
     * @param stops2
     */
    public void setOne_change(String start, String middle, String end, String line, String line2, int stops, int stops2){
        (no_change).setVisible(false);
        (one_change).setVisible(true);
        (two_change).setVisible(false);
        oclinename1.setText(line + " Line");
        oclinename2.setText(line2 + " Line");
        ocstartstn.setText(start);
        ocmiddlestn2.setText(middle);
        ocmiddlestn.setText(middle);
        ocendstn.setText(end);
        ocstops.setText(stops + " stops");
        ocstops2.setText(stops2 + " stops");
        ocline1.setStroke(Color.RED);
        ocline2.setStroke(Color.BLUE);
        // find find start to end
    }

    /**
     * Is meant to display route with 2 changes
     *
     * @param start
     * @param middle
     * @param middle2
     * @param end
     * @param line
     * @param line2
     * @param line3
     * @param stops
     * @param stops2
     */
    public void setTwo_change(String start, String middle, String middle2, String end, String line, String line2, String line3, int stops, int stops2){
        (no_change).setVisible(false);
        (one_change).setVisible(false);
        (two_change).setVisible(true);
        tclinename1.setText(line + " Line");
        twoclinename2.setText(line2 + " Line");
        tclinename3.setText(line3 + " Line");
        tcstart.setText(start);
        tcend.setText(end);
        tcmiddlestn1.setText(middle);
        tcmiddlestn2.setText(middle2);
        tcstop1.setText(stops + " stops");
        tcstop2.setText(stops2 + " stops");
        tcline1.setStroke(Color.RED);
        tcline2.setStroke(Color.BLUE);
        tcline3.setStroke(Color.GREEN);
        // find find start to end
    }

    public String getStart(){ return Start; }

    public String getEnd(){ return End; }


}
