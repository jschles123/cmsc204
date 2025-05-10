import java.util.ArrayList;

public class Road implements Comparable<Road>{

    Town town1;
    Town town2;
    int distance;
    String name;

    public Road(Town town1, Town town2, int distance, String name) {
        this.town1 = town1;
        this.town2 = town2;
        this.distance = distance;
        this.name = name;
    }

    public Town getTown1() {
        return town1;
    }

    public void setTown1(Town town1) {
        this.town1 = town1;
    }

    public Town getTown2() {
        return town2;
    }

    public void setTown2(Town town2) {
        this.town2 = town2;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Road o) {
        if(!(this.distance == o.distance)) {
            return -1;
        }else if(this.town1.equals(o.town1) && this.town2.equals(o.town2)) {
                return 0;
            }else if(this.town1.equals(o.town2) && this.town2.equals(o.town1)) {
                return 0;
            }
            return -1;
        }
}
