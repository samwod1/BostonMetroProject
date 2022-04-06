

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class InputReader {

    public static final String divider = " ";

    public static ArrayList readFile(String fileLocation) {
        ArrayList<ArrayList<String>> textLines = new ArrayList();
        try {
            File inputFile = new File(fileLocation);
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line = "";

            while((line = br.readLine()) != null) {
                String [] temp;
                ArrayList<String> current = new ArrayList<>();
                temp = line.replaceAll("[^A-Za-z0-9/.']"," ").split(divider);
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i]!=""){
                        current.add(temp[i]);
                    }
                }
                //printData(current);
                textLines.add(current);
            }
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return textLines;
        //need to put this in network constructor
        //createStationsLines(textLines);
    }

    //[[1, Oakgrove, Orange, 0, 2],[2, Malden, Orange, 1, 5]]
    public static void printData(ArrayList current){
        for (int i = 0; i < current.size(); i++) {
            System.out.print("|"+current.get(i)+"|" + " ");
        }
        System.out.println();
    }

}
