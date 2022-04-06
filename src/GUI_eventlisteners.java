import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.SetChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;
import java.util.List;

public class GUI_eventlisteners implements Initializable {

        Controller controller = new Controller();
        private Stage stage;
        private Scene scene;
        private Parent root;
        String Start = "";
        String End = "";


         /**
         * Set Up Ids od the fxml file objects
         */
        @FXML
        private ListView<String> fromListView;
        @FXML
        private ListView<String> toListView;
        @FXML
        private ListView<String> resultingPath;
        @FXML
        private ComboBox<String> fromLineDropDown;
        @FXML
        private ComboBox<String> toLineDropdown;
        @FXML
        private TextField fromtxt;
        @FXML
        private TextField totxt;
        @FXML
        private Label command;


        /**
         *
         * Populates the combo boxes
         *
         * @param url
         * @param resourceBundle
         */
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle){
                String[] lines = controller.getLineNames().toArray(new String[0]);

                fromtxt.setText(Start);
                totxt.setText(End);


                fromLineDropDown.setPromptText("Choose Line");
                fromLineDropDown.getItems().addAll(lines);
                fromLineDropDown.setOnAction(this::getFromLine);
                toLineDropdown.setPromptText("Choose Line");
                toLineDropdown.getItems().addAll(lines);
                toLineDropdown.setOnAction(this::getToLine);

                }

        /**
         * Submit button for the text Fields not linked with Listview yet. Need away for error checking
         *
         * @param event
         */
        public void submitBtnText(ActionEvent event){
                try {
                Start = fromtxt.getText();
                End = totxt.getText();

                Boolean[] errorCheck = controller.errorCheck(Start,End);

                if (!errorCheck[0] || !errorCheck[1]){
                        command.setText("Please enter valid stations.");
                } else{
                        finalRoute(Start, End);
                        command.setText("");
                }

                } catch (Exception e) {
                System.out.println(e);
                }
        }

        /**
         * Submits when first 2 list views are chosen
         * @param event
         */
        public void submitBtnList(ActionEvent event){
                try {
                        ObservableList<String> fromObs;
                        ObservableList<String> toObs;
                        fromObs = fromListView.getSelectionModel().getSelectedItems();
                        toObs = toListView.getSelectionModel().getSelectedItems();
                        String from = fromObs.get(0);
                        String to = toObs.get(0);
                        if (!(null == from) && !(null == to)) {



                           //    from += fromObs.toString().substring(1, 3 * fromObs.size() - 1).replaceAll("[^a-zA-Z]", "");
                            //    to += toObs.toString().substring(1, 3 * toObs.size() - 1).replaceAll("[^a-zA-Z]", "");


                                Start = from;
                                End = to;

                                fromtxt.clear();
                                totxt.clear();

                                finalRoute(from, to);
                        }
                } catch (Exception e) {
                        System.out.println(e);
                }
        }

        /**
         * Switches scene to the map
         *
         * @param event
         * @throws IOException
         */
        public void switchToMapBtn(ActionEvent event) throws IOException {
                try {
                Parent root = FXMLLoader.load(getClass().getResource("map.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene mapScene = new Scene(root);
                this.stage.setScene(mapScene);
                stage.show();
                } catch (Exception e) {
                e.printStackTrace();
                }
        }

        /**
         * Sets up the from list view depending on corresponding combo box choice. Needs a function to get chosen line's stations
         * from Another class. Set up atm to test dummy data
         *
         * @param event
         */
        public void getFromLine(ActionEvent event){
                String linename = fromLineDropDown.getValue();
                ArrayList<String> stnNames = controller.getLineStations(linename);
                ObservableList<String> observableList = FXCollections.observableList(stnNames);
                fromListView.getItems().clear();
                fromListView.getItems().addAll(observableList);
         }

        /**
         * Sets up the to list view depending on corresponding combo box choice. Needs a function to get chosen line's stations
         * from Another class. Set up atm to test dummy data
         *
         * @param event
         */
        public void getToLine(ActionEvent event){
                String linename = toLineDropdown.getValue();
                ArrayList<String> stnNames = controller.getLineStations(linename);
                ObservableList<String> observableList = FXCollections.observableList(stnNames);
                toListView.getItems().clear();
                toListView.getItems().addAll(observableList);
        }

        /**
         * method to get the final path. Will be called by both submit buttons. Needs a function to get from another class
         *
         * @param to
         * @param from
         */
        public void finalRoute(String to, String from){
                List<String[]> pathStns = controller.getLineRoute(to, from);
                List<String> pathCombine = new ArrayList<>();
                String line = "";
                for(int i = 0; i < pathStns.size(); i++){

                 //       if(pathStns.get(i)[2] == null) {
                        if (lineShort(pathStns.get(i)[1])!="") {
                                line = lineShort(pathStns.get(i)[1]);
                        }
                        String station = pathStns.get(i)[0];
                        if(i+1<pathStns.size()) {
                                if (pathStns.get(i)[1].equals(pathStns.get(i + 1)[1])) {
                                        station = line + " " + station;
                                } else {
                                        String lineChange = lineShort(pathStns.get(i + 1)[1]);
                                        station = line + " > " + lineChange + " " + station;
                                }
                        } else if (pathStns.size()-1 == i){
                                station = line + " " + station;
                        }
                        pathCombine.add(station);

                }
                ObservableList<String> pathObs = FXCollections.observableList(pathCombine);
                resultingPath.getItems().clear();
                resultingPath.getItems().addAll(pathObs);

        }

        public boolean letterCheck(String name) {
                return name.matches("[^A-Za-z0-9/.']");
        }

        public String lineShort(String line){
                String shrtLine = "";
                switch(line) {
                        case "Red" :
                                shrtLine = "|R";
                                break;
                        case "RedA" :
                                shrtLine = "|RA";
                                break;

                        case "RedB" :
                                shrtLine = "|RB";
                                break;
                        case "Blue" :
                                shrtLine = "|B";
                                break;
                        case "Orange" :
                                shrtLine = "|O";
                                break;
                        case "Mattapan" :
                                shrtLine = "|M";
                                break;
                        case "Green" :
                                shrtLine = "|G";
                                break;
                        case "GreenB" :
                                shrtLine = "|GB";
                                break;
                        case "GreenC" :
                                shrtLine = "|GC";
                                break;
                        case "GreenD" :
                                shrtLine = "|GD";
                                break;
                        case "GreenE" :
                                shrtLine = "|GE";
                                break;
                        default :
                                System.out.println("Line wrong syntax");
                }
                return shrtLine;
        }

}
