package src;

import javafx.application.Application;
import javafx.event.ActionEvent;

public class Driver {




    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(GUI_create.class);
            }
        }.start();
        GUI_create runGUI = GUI_create.waitForStartUpTest();
      //  runGUI.submitbtn(ActionEvent event);
    }


}
