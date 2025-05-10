import java.util.ArrayList;

public class Town implements Comparable<Town>{


    private String name;
    private ArrayList<Town> towns;
    private ArrayList<Road> roads;

    Town(String name) {
        this.name = name;
        this.towns = new ArrayList<>();
    }




    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(Town other) {
        return this.name.equals(other.getName()) ? 0 : -1;
    }
}
