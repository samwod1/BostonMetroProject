
public class Station {

    Station previous;
    Station next;
    String name;
    String line;

    public Station(String name, String line) {
        this.name = name;
        this.line = line;
    }

    public void Station(Station previous, Station next, String name, String line) {
        this.previous = previous;
        this.next = next;
        this.name = name;
        this.line = line;
    }

    public void setPreviousNext(Station previous, Station next){
        this.previous = previous;
        this.next = next;
    }

    public Station getPrevious() { return previous; }

    public void setPrevious(Station previous) { this.previous = previous; }

    public Station getNext() { return next; }

    public void setNext(Station next) { this.next = next; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
