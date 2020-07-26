import java.util.HashSet;
import java.util.Set;

/*
 *
 * Class Name: Unit
 * Author: Wei Jian Lai
 */
public class Unit{
	
	/* ------------------------------------------- ArrayList versus array ----------------------------------------------------
	 *  As there is no fixed number of students who will be enrolled in the unit, I have used ArrayList instead of a normal
	 *  array as the size of the array cannot be changed as opposed to one in ArrayList. 
	  --------------------------------------- Why use the Set Collection Class -----------------------------------------------
	 *  As no unit can have a student enrolled twice, the no duplicate elements rule for the Set Collection will not be a 
	 *  hindrance to the code. Also it is fitting as the interface model is used to represent sets, in this case, the student
	 *  ID. A HashSet implementation is used as the order of the students is not relevant when retrieving enrolledStudents so
	 *  performance is optimised.
	 * ----------------------------------------------------------------------------------------------------------------------- 
	 */
	// Global variables for the unit code, name, university, enrolled students and assessment scheme.
    private String unitCode;
    private String unitName;
    private University unitUniversity;
	private Set<String> enrolledStudents = new HashSet<String>();
	private AssessmentScheme assessmentScheme;
	
    // Constructor for the Unit class
    public Unit(String code, String name, University university) {
        unitCode = code;
        unitName = name;
        unitUniversity = university;
    }
    
    // Constructor for the Unit class without the University instance
    public Unit(String code, String name) {
        unitCode = code;
        unitName = name;
    }
    
    // Copy Constructor
    public Unit(Unit unit) {
    	unitCode = unit.unitCode;
    	unitName = unit.unitName;
    	unitUniversity = unit.unitUniversity;
    	enrolledStudents = unit.enrolledStudents;
    	assessmentScheme = unit.assessmentScheme;
    }
    
    /*
     * Accessor: returns the array list of Students enrolled in this unit (not user readable)
     */
	public Student[] getEnrolledStudents() {
		Student[] studentArray = new Student[enrolledStudents.size()];
		int i = 0;
		for (String studentId : enrolledStudents) {
			studentArray[i] = new Student(unitUniversity.getStudent().get(studentId));
			i += 1;
		}
		return studentArray;
	}
	
	/*
     * Mutator: Sets the Assessment Scheme for the unit
     */
    public void setAssessmentScheme(Set<Assessment> assessments) {
		assessmentScheme = new AssessmentScheme(assessments);
    }
    
    /*
     * Function: concatenate the unitCode and unitName variable with a space in between
     */
    public String description() {
        return unitCode + " " + unitName;
    }
    
    /*
     * Function: Enrols the student into the unit by adding the student ID to the HashSet
     */
    public void enrolStudent(String newStudentId) {
    	enrolledStudents.add(newStudentId);
    }
    
    /*
     * Function: Takes a student ID input and checks if the student has completed all exams in the unit
     */
    public Boolean verifyAssessmentCompletion(String studentId) {
        // The iterator used to look through the HashSet
    	for(Assessment assessment : assessmentScheme.getAssessments()) {
    		// Gets the Mark object of the student's unit assessment which is being iterated
    		Mark studentMark = assessment.getStudentMarks().get(studentId);
    		if(studentMark == null) {
    			return false;
    		}
    	}
    	return true;	 	
    }
    
    /*
     * Function: Calculates the total marks of the student specified
     */
    public float getTotalMarks(String studentId) {
    	float totalMarks = 0;
    	if (this.verifyAssessmentCompletion(studentId) == true) {
        	for(Assessment assessment : assessmentScheme.getAssessments()) {
    		    // Retrieves a mark from the mark class
    		    int studentMarksMultiplier = assessment.getStudentMarks().get(studentId).getMark();
    		    int weight = assessment.getWeight();
                totalMarks += (studentMarksMultiplier * weight)/100.0;
    	    }
    	} //else {
    	//	System.out.println("The student has not completed all assessments yet ignore the marks below this is for testing only");
	    //}
    	return totalMarks;	 	
    }
}
