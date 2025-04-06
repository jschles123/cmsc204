import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class represents a hash table structure used to store CourseDBElement objects.
 * @Author Joshua Schlesinger-Guevara
 */
public class CourseDBStructure implements CourseDBStructureInterface {

    /** Array of LinkedLists representing the hash table */
    private LinkedList<CourseDBElement>[] hashArr;

    /** The number of elements in the structure */
    private int size = 0;

    /**
     * Constructor that creates a hash table with a size based on the closest prime number of the form 4k+3.
     *
     * @param size The initial size to base the hash table on
     */
    public CourseDBStructure(int size) {
        int tableSize = getPrime(size);
        hashArr = new LinkedList[tableSize];
    }

    /**
     * Overloaded constructor used for testing purposes.
     *
     * @param testing A dummy string parameter to differentiate the constructor
     * @param i The desired size of the hash table
     */
    public CourseDBStructure(String testing, int i) {
        this.hashArr = new LinkedList[i];
        this.size = i;
    }

    /**
     * Adds a CourseDBElement to the structure.
     * If an element with the same CRN exists, it updates its fields.
     *
     * @param element The CourseDBElement to add
     */
    @Override
    public void add(CourseDBElement element) {
        try {
            CourseDBElement temp = this.get(element.getCRN());
            temp.setCredits(element.getCredits());
            temp.setCRN(element.getCRN());
            temp.setID(element.getID());
            temp.setRoom(element.getRoomNum());
        } catch (IOException e) {
            int hash = Math.abs(element.hashCode()) % this.hashArr.length;

            if (this.hashArr[hash] == null) {
                this.hashArr[hash] = new LinkedList<>();
            }

            this.hashArr[hash].add(element);
            this.size++;
        }
    }

    /**
     * Retrieves a CourseDBElement from the structure using its CRN.
     *
     * @param crn The CRN of the course to retrieve
     * @return The corresponding CourseDBElement
     * @throws IOException If the element is not found
     */
    @Override
    public CourseDBElement get(int crn) throws IOException {
        CourseDBElement temp = new CourseDBElement(null, crn, -1, null, null);
        int hash = Math.abs(temp.hashCode()) % this.hashArr.length;

        if (this.hashArr[hash] == null) {
            throw new IOException("CRN not found.");
        }

        for (CourseDBElement i : this.hashArr[hash]) {
            if (i.getCRN() == crn) {
                return i;
            }
        }

        throw new IOException("CRN not found.");
    }

    /**
     * Displays all stored CourseDBElements as strings in an ArrayList.
     *
     * @return An ArrayList containing the string representations of all elements
     */
    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> arr = new ArrayList<>();

        for (LinkedList<CourseDBElement> bucket : this.hashArr) {
            if (bucket != null) {
                for (CourseDBElement element : bucket) {
                    arr.add(element.toString());
                }
            }
        }

        return arr;
    }

    /**
     * Gets the current size of the hash table array.
     *
     * @return The number of buckets in the table
     */
    @Override
    public int getTableSize() {
        return this.hashArr.length;
    }

    /**
     * Checks if a given number is a prime number.
     *
     * @param number The number to check
     * @return True if the number is prime, false otherwise
     */
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    /**
     * Finds the closest prime number to the input number that is also of the form 4k+3.
     *
     * @param number The starting number to search from
     * @return The closest prime number of the form 4k+3
     */
    private int getPrime(int number) {
        int offset = 0;
        while (true) {
            int down = number - offset;
            int up = number + offset;

            if (down > 2 && isPrime(down) && down % 4 == 3) return down;
            if (isPrime(up) && up % 4 == 3) return up;

            offset++;
        }
    }
}
