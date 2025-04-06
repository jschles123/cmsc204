import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The CourseDBManager class handles course data operations such as
 * adding, retrieving, and loading courses from a file.
 * @Author Joshua Schlesinger-Guevara
 */
public class CourseDBManager implements CourseDBManagerInterface {

    /** The underlying data structure that stores course information */
    private CourseDBStructureInterface hashObject;

    /**
     * Default constructor that initializes the database structure
     * with a default size of 10.
     */
    public CourseDBManager() {
        this.hashObject = new CourseDBStructure(10);
    }

    /**
     * Adds a course to the database.
     *
     * @param id         The course ID
     * @param crn        The Course Registration Number
     * @param credits    The number of credits for the course
     * @param roomNum    The room number where the course is held
     * @param instructor The instructor's name
     */
    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        hashObject.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
    }

    /**
     * Retrieves a course from the database using the CRN.
     *
     * @param crn The Course Registration Number to search for
     * @return The CourseDBElement if found, or null otherwise
     */
    @Override
    public CourseDBElement get(int crn) {
        try {
            return this.hashObject.get(crn);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Reads course data from a file and adds each entry to the database.
     * Assumes each line is formatted as: ID CRN CREDITS ROOM INSTRUCTOR
     *
     * @param input The file containing course data
     * @throws FileNotFoundException If the file is not found
     */
    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner reader = new Scanner(input);
        String data;
        while (reader.hasNextLine()) {
            data = reader.nextLine();
            String[] arr = data.split(" ");
            this.add(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), arr[3], arr[4]);
        }
        reader.close();
    }

    /**
     * Returns a list of all courses in the database.
     *
     * @return An ArrayList of course information in string format
     */
    @Override
    public ArrayList<String> showAll() {
        return this.hashObject.showAll();
    }
}
