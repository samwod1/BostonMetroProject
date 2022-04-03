



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

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;
import java.util.List;


public class GUI_eventlisteners implements Initializable {

         private Stage stage;
         private Scene scene;
         private Parent root;
         String Start;
         String End;


         /**
         * Set Up Listviews and Combo boxes
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


        String[] lines = {"Red", "RedA", "RedB", "Blue", "Orange", "Mattapan",
                "Green", "GreenA", "GreenB", "GreenC", "GreenD", "GreenE"};


        /**
         *
         * Populates the combo boxes
         *
         * @param url
         * @param resourceBundle
         */
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

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
        public void submitbtn(ActionEvent event) {
                try {
                Start = fromtxt.getText();
                End = totxt.getText();
                setTwo_change(Start, "Charring Cross", "Haymarket", End, "Red", "Blue", "Yellow", 4, 6);
                //submitbtn.addActionlistener(event);

                } catch (Exception e) {
                System.out.println(e);
                }
        }

        /**
         * Submits when first 2 list views are chosen
         * @param event
         */
        public void submitbtn2(ActionEvent event) {
                try {
                        ObservableList<String> fromObs;
                        ObservableList<String> toObs;

                        fromObs = fromListView.getSelectionModel().getSelectedItems();
                        toObs = toListView.getSelectionModel().getSelectedItems();

                        if (!fromObs.isEmpty() && !toObs.isEmpty()) {

                                String from = "";
                                String to = "";

                                from += fromObs.toString().substring(1, 3 * fromObs.size() - 1).replaceAll(", ", "");
                                to += toObs.toString().substring(1, 3 * toObs.size() - 1).replaceAll(", ", "");

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
         * Will Display A line if theres no changes. Probs needs some adjusting and could be removed if no time. For the colourful route thingy
         *
         * @param start
         * @param end
         * @param line
         * @param stops
         */
        public void setNo_change(String start, String end, Array line, int stops) {
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
         * Is meant to display the route with one change. Probs needs some adjusting and could be removed if no time. For the colourful route thingy
         *
         * @param start
         * @param middle
         * @param end
         * @param line
         * @param line2
         * @param stops
         * @param stops2
         */
        public void setOne_change(String start, String middle, String end, String line, String line2, int stops, int stops2) {
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
         * Is meant to display route with 2 changes. Probs needs some adjusting and could be removed if no time. For the colourful route thingy
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
        public void setTwo_change(String start, String middle, String middle2, String end, String line, String line2, String line3, int stops, int stops2) {
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

        /**
         * Sets up the from list view depending on corresponding combo box choice. Needs a function to get chosen line's stations
         * from Another class. Set up atm to test dummy data
         *
         * @param event
         */
        public void getFromLine(ActionEvent event){
                String linename = fromLineDropDown.getValue();
                //List<String> firstLine = getStations(linename); Placeholder, function to get stations for first chosen line. Links with another class. Uses 1 string

                if (linename.equals("GreenA")) {
                        String[] stn = {"a", "b", "c"};

                        /**
                         * Just below this is useful and converts line list to observable list then populates the Listview. If statement not needed
                         */
                        List<String> stations = Arrays.asList(stn);
                        ObservableList<String> observableList = FXCollections.observableList(stations);
                        fromListView.getItems().clear();
                        fromListView.getItems().addAll(observableList);
                }
                //for testing no needed
                if (linename.equals("GreenB")) {
                        String[] stn = {"e", "r", "x"};
                        List<String> stations = Arrays.asList(stn);
                        ObservableList<String> observableList = FXCollections.observableList(stations);
                        fromListView.getItems().clear();
                        fromListView.getItems().addAll(observableList);
                }
         }

        /**
         * Sets up the to list view depending on corresponding combo box choice. Needs a function to get chosen line's stations
         * from Another class. Set up atm to test dummy data
         *
         * @param event
         */
        public void getToLine(ActionEvent event){
                String linename = toLineDropdown.getValue();
                //List<String> secondLine = getStations(linename); Placeholder, function to get stations for first chosen line. Links with another class. Uses 1 string

                if (linename.equals("GreenA")) {
                        String[] stn = {"a", "b", "c"};

                        /**
                         * Just below this is useful and converts line list to observable list then populates the Listview. If statement not needed
                         */
                        List<String> stations = Arrays.asList(stn);
                        ObservableList<String> stnsObs = FXCollections.observableList(stations);
                        toListView.getItems().clear();
                        toListView.getItems().addAll(stnsObs);
                }

                //for testing no needed
                if (linename.equals("GreenB")) {
                        String[] stn = {"e", "r", "x"};
                        List<String> stations = Arrays.asList(stn);
                        ObservableList<String> stnsObs = FXCollections.observableList(stations);
                        toListView.getItems().clear();
                        toListView.getItems().addAll(stnsObs);
                }
        }

        /**
         * method to get the final path. Will be called by both submit buttons. Needs a function to get from another class
         *
         * @param to
         * @param from
         */
        public void finalRoute(String to, String from){
                //List<String> path = function to find path. Links with another class. Uses 2 strings
                String[] stn = {to, "p", from}; // For dummy test
                List<String> path = Arrays.asList(stn);
                ObservableList<String> pathObs = FXCollections.observableList(path);
                resultingPath.getItems().clear();
                resultingPath.getItems().addAll(pathObs);

        }


}
