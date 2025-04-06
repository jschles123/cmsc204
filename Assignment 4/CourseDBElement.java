import java.util.Objects;

/**
 * This class represents a course database element containing information such as
 * course ID, CRN, number of credits, room number, and instructor.
 * @Author Joshua Schlesinger-Guevara
 */
public class CourseDBElement implements Comparable<CourseDBElement>{

    /** The course ID */
    private String ID;

    /** The Course Registration Number (CRN) */
    private int CRN;

    /** The number of credits the course is worth */
    private int credits;

    /** The room number where the course is held */
    private String room;

    /** The name of the instructor */
    private String instructor;

    /**
     * Default constructor.
     */
    public CourseDBElement() {}

    /**
     * Parameterized constructor that initializes all fields of the course.
     *
     * @param ID The course ID
     * @param CRN The Course Registration Number
     * @param credits Number of credits
     * @param room Room number
     * @param instructor Instructor's name
     */
    public CourseDBElement(String ID, int CRN, int credits, String room, String instructor) {
        this.ID = ID;
        this.CRN = CRN;
        this.credits = credits;
        this.room = room;
        this.instructor = instructor;
    }


    /**
     * Computes the hash code based on the CRN.
     *
     * @return The hash code of the CRN
     */
    @Override
    public int hashCode() {
        return Integer.toString(CRN).hashCode();
    }

    /**
     * Gets the course ID.
     *
     * @return The course ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets the course ID.
     *
     * @param ID The course ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Gets the CRN (Course Registration Number).
     *
     * @return The CRN
     */
    public int getCRN() {
        return CRN;
    }

    /**
     * Sets the CRN.
     *
     * @param CRN The CRN to set
     */
    public void setCRN(int CRN) {
        this.CRN = CRN;
    }

    /**
     * Gets the number of credits for the course.
     *
     * @return The number of credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Sets the number of credits for the course.
     *
     * @param credits The number of credits to set
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Sets the room number for the course.
     *
     * @param room The room number to set
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * Gets the room number where the course is held.
     *
     * @return The room number
     */
    public String getRoomNum() {
        return this.room;
    }

    /**
     * Returns a string representation of the CourseDBElement.
     *
     * @return A formatted string with all course information
     */
    @Override
    public String toString() {
        return "Course: " + ID + " CRN:" + CRN + " Credits:" + credits +
                " Instructor:" + instructor + " Room:" + room;
    }

    @Override
    public int compareTo(CourseDBElement o) {
        return this.getCRN() - o.getCRN();
    }
}
