package coll.EnrollmentManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Static class for managing student enrollments.
 */
public class EnrollmentManager {

    /**
     * Map containing <unit, students> pairs.
     */
    private static Map<String, Set<String>> enrollments = new HashMap<String, Set<String>>();

    /**
     * Enrolls a student into a unit.
     *
     * @param unit - the unit for the student to be enrolled
     * @param student - the student
     */
    public static void enroll(String unit, String student) {
        //if unit doesn't exist in enrollments
        if (!enrollments.containsKey(unit)){
            //create a new pair
            enrollments.put(unit, new HashSet<String>());
        }
        //create set comprising of students studying a particular unit
        Set<String> students = enrollments.get(unit);
        //add student to unit
        students.add(student);

    }

    /**
     * Gets the HashMap containing the current enrollments.
     *
     * @return the enrollments
     */
    public static Map<String, Set<String>> getEnrollments() {
        return enrollments;
    }

    /**
     * Removes all enrollments form the HashMap.
     */
    public static void wipeEnrollments() {
        enrollments.clear();
    }

    /**
     * Withdraws a student from a unit.
     *
     * @param unit - the unit for the student to be withdrawn from
     * @param student - the student
     */
    public static void withdrawEnrollment(String unit, String student) {
        for (Map.Entry<String, Set<String>> entries : enrollments.entrySet()){
            if (enrollments.containsKey(unit)){
                Set<String> studentEnrollments = enrollments.get(unit);
                studentEnrollments.remove(student);
            }
        }

    }

    /**
     * Withdraws a student from all units they are enrolled in.
     *
     * @param student - the student
     */
    public static void withdrawStudent(String student) {
        //for each entry in the hashmap

        //Iterate through keySet in enrollments
        for (String unit : enrollments.keySet()) {
            //if a unit contains student
            if (enrollments.get(unit).contains(student)){
                //get the specified unit with student
                Set<String> enrolStudent = enrollments.get(unit);
                //remove student from that unit
                enrolStudent.remove(student);
                //associate unit with new list of enrolled students
				enrollments.put(unit, enrolStudent);
            }

        }
    }

    /**
     * Gets a set of all students of a particular discipline. E.g. If discipline is
     * "ABC" then return a collection of all students enrolled in units that start
     * with "ABC", so ABC301, ABC299, ABC741 etc.
     *
     * @param discipline - the discpline
     * @return the set of students
     */
    public static Set<String> getStudents(String discipline) {
        Set<String> students = new HashSet<>();
        for(String entry : enrollments.keySet()){
            //if unit contains a substring of discipline
            if (entry.startsWith(discipline)){
                //add all the students of that unit into temperary set<string>
				students.addAll(enrollments.get(entry));
            }
        }
        //return set of all students
        return students;

    }
}