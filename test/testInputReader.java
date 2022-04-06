import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class testInputReader {

    InputReader reader = new InputReader();
    ArrayList<ArrayList<String>> testFile = reader.readFile("src\\input reader test file.txt");
    ArrayList<ArrayList<String>> stationsFile = reader.readFile("src\\bostonmetro.txt");

    //this set of testReaderStationsFile methods
    //test 3 selected lines within the bostonmetro.txt file
    //by asserting that the output of inputReader is what is expected

    @Test
    public void testReaderStationsFile1(){

        String stationNumber = stationsFile.get(0).get(0);
        String stationName = stationsFile.get(0).get(1);
        String lineName = stationsFile.get(0).get(2);
        String connection1 = stationsFile.get(0).get(3);
        String connection2 = stationsFile.get(0).get(4);

        assertEquals(stationNumber, "1");
        assertEquals(stationName, "OakGrove");
        assertEquals(lineName, "Orange");
        assertEquals(connection1, "0");
        assertEquals(connection2, "2");
    }

    //tests station 41 is read in correctly by input reader
    @Test
    public void testReaderStationsFile41(){

        String stationNumber = stationsFile.get(40).get(0);
        String stationName = stationsFile.get(40).get(1);

        String lineName1 = stationsFile.get(40).get(2);
        String connection1 = stationsFile.get(40).get(3);
        String connection2 = stationsFile.get(40).get(4);
        String lineName2 = stationsFile.get(40).get(5);
        String connection3 = stationsFile.get(40).get(6);
        String connection4 = stationsFile.get(40).get(7);
        String lineName3 = stationsFile.get(40).get(8);
        String connection5 = stationsFile.get(40).get(9);
        String connection6 = stationsFile.get(40).get(10);
        String lineName4 = stationsFile.get(40).get(11);
        String connection7 = stationsFile.get(40).get(12);
        String connection8 = stationsFile.get(40).get(13);

        assertEquals(stationNumber, "41");
        assertEquals(stationName, "Copley");

        assertEquals(lineName1, "GreenB");
        assertEquals(connection1, "51");
        assertEquals(connection2, "34");

        assertEquals(lineName2, "GreenC");
        assertEquals(connection3, "51");
        assertEquals(connection4, "34");

        assertEquals(lineName3, "GreenD");
        assertEquals(connection5, "51");
        assertEquals(connection6, "34");

        assertEquals(lineName4, "GreenE");
        assertEquals(connection7, "53");
        assertEquals(connection8, "34");

    }

    @Test
    public void testReaderStationsFile124(){

        String stationNumber = stationsFile.get(123).get(0);
        String stationName = stationsFile.get(123).get(1);

        String lineName1 = stationsFile.get(123).get(2);
        String connection1 = stationsFile.get(123).get(3);
        String connection2 = stationsFile.get(123).get(4);

        assertEquals(stationNumber,"124");
        assertEquals(stationName, "Braintree");
        assertEquals(lineName1, "RedB");
        assertEquals(connection1, "0");
        assertEquals(connection2, "123");

    }

    //this tests is using a separate file to reinforce the
    //robustness of the inputReader class, the file is populated
    //sporadically with information

    //this test checks if the inputReader reads in the correct information

    @Test
    public void testReaderTestFile(){
        System.out.println(testFile);
        String stationNumber = testFile.get(0).get(0);
        String stationName = testFile.get(0).get(1);

        String lineName1 = testFile.get(0).get(2);
        String connection1 = testFile.get(0).get(3);
        String connection2 = testFile.get(0).get(4);

        String stationNumber1 = testFile.get(2).get(0);
        String stationName1 = testFile.get(2).get(1);

        String lineName2 = testFile.get(2).get(2);
        String connection3 = testFile.get(2).get(3);
        String connection4 = testFile.get(2).get(4);

        String stationNumber2 = testFile.get(3).get(0);
        String stationName2 = testFile.get(3).get(1);

        String lineName3 = testFile.get(3).get(2);
        String connection5 = testFile.get(3).get(3);
        String connection6 = testFile.get(3).get(4);


        assertEquals(stationNumber, "1");
        assertEquals(stationName, "Salmon");
        assertEquals(lineName1, "Jungle");
        assertEquals(connection1, "4");
        assertEquals(connection2, "5");

        assertEquals(stationNumber1, "3");
        assertEquals(stationName1, "Hugh");
        assertEquals(lineName2, "Mingle");
        assertEquals(connection3, "1");
        assertEquals(connection4, "6");

        assertEquals(stationNumber2, "100");
        assertEquals(stationName2, "Mark");
        assertEquals(lineName3, "Post");
        assertEquals(connection5, "130");
        assertEquals(connection6, "10000");
    }


}
