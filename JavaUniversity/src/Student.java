/*
 *
 * Class Name: Student
 * Author: Wei Jian Lai
 */
public class Student {

	/* 
	 * ------------------------------------------Variable type and name decisions ------------------------------------------------
	 * NOTE: Advantages of Using int for studentId:
	 *   Takes up less memory space
	 * NOTE: Disadvantages of Using int for studentId:
	 *   Requires integer to be converted to a string before printing, in the case where the student ID starts with 0
	 *   it will cause an error
	 * NOTE: Advantages of Using String for studentId:
	 * 	 No conversion is required if a String type were to be used, since there will be no code needed for type conversion
	 * NOTE: Disadvantages of Using String for studentId:
	 *   Takes up more memory space
	 * NOTE: Final Decision:
	 *   In the end i chose to use the String type as I believe that it will cause less errors in the long run, it is a 
	 *   necessary tradeoff as compared to memory space usage.
	 * NOTE: "firstName" and "lastName" vs "givenName" and "familyName":
	 *   As students come from all around the world there will be some students who are not familiar with
	 * 	 the terms "firstName" and "lastName" due to the different naming schemes across different cultures.
	 * 	 As for "givenName" and "familyName" it is more universally known and the format is used across most cultures.
	 * 	 Hence, less confusion will occur as more people are aware of the "givenName" and "familyName" format.
	 * ---------------------------------------------------------------------------------------------------------------------------
	 */
	// Global variables used to store student details
    private String studentId;
    private String givenName;
    private String familyName;
	
    // Constructor for 1 input which is of a String type
    public Student(String newStudentId) {
    	if (newStudentId.length() != 8) {
    		throw new IllegalArgumentException("Valid Student ID must be 8 characters long");
    	}
        studentId = newStudentId;
	}

    // Constructor for 3 inputs of a String type
    public Student(String newStudentId, String newGivenName, String newFamilyName) {
    	if (newStudentId.length() != 8) {
    		throw new IllegalArgumentException("Valid Student ID must be 8 characters long");
    	}
        studentId = newStudentId;
        givenName = newGivenName;
        familyName = newFamilyName;
	}
    
    // Copy constructor to prevent privacy leaks
    public Student(Student student) {
    	if (student.studentId.length() != 8) {
    		throw new IllegalArgumentException("Valid Student ID must be 8 characters long");
    	}
    	studentId = student.studentId;
    	givenName = student.givenName;
    	familyName = student.familyName;
    }
    
    /*
     * Accessor: Retrieves studentId
     */
    public String getStudentId() {
    	return studentId;
    }
	
    /*
     *  Mutator: Alters student's given name input
     */
    public void setGivenName(String newGivenName) {
        givenName = newGivenName;	
    }
    
    /*
     *  Mutator: Alters the student's family name input
     */
    public void setFamilyName(String newFamilyName) {
        familyName = newFamilyName;	
    }
    
    /*
     * Function: Prints out a user readable version of the student details
     */
    public String description() {
    	return studentId + " " + givenName + " " + familyName;
    }
}

