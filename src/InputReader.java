
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class InputReader {

    public static final String divider = "";

    public static ArrayList readFile(String file) {
        ArrayList textLines = new ArrayList();
        try {
            File inputFile = new File(file);
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line = "";

            while((line = br.readLine()) != null) {
                String[] temp = line.split(divider);
                textLines.add(temp);
                for(String str : temp) { System.out.print(str + " "); }
            }
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return textLines;
        //need to put this in network constructor
//        createStationsLines(textLines);
    }



}
