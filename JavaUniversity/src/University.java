import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;

/*
 *
 * Class Name: University
 * Author: Wei Jian Lai
 * 
 * TODO: error checking
 */
public class University {
	
	// Global variable used to store a list of Units, students enrolled in the university, and 
	private ArrayList<Unit> unitArray = new ArrayList<Unit>();
	private HashMap<String, Student> students = new HashMap<String, Student>();
	private Set<Course> courses = new HashSet<Course>();
	
    /*
     * Accessor: Returns the students that were enrolled in the university
     */
    protected HashMap<String, Student> getStudent() {
    	HashMap<String, Student> studentCopy = new HashMap<String, Student>();
    	Iterator<Entry<String, Student>> studentIterator = students.entrySet().iterator();
		while (studentIterator.hasNext()) {
			Entry<String, Student> student = studentIterator.next();
			studentCopy.put(student.getKey(), new Student(student.getValue()));
		}
    	return studentCopy;
    } 
    
    /*
     * Function: Prints the welcome message followed by the unit and student status ending with a goodbye message
     */
    public void printStatus() {
        System.out.println("Welcome to Java University.");			
        try {
			this.createUnits();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}											
        this.displayUnits();
        System.out.println();   
        System.out.println("Thanks for using Java University.");   	
    }
    
    /*
     * Function: Creates units, students, assessments and its subclasses, assessment schemes, marks and runs tests for their corresponding methods
     */
    public void createUnits() {
    	
    	// Creates 3 students
    	Student student1 = new Student("12345678", "Victor", "Chang");
        Student student2 = new Student("12345679", "Fred", "Nurke");
        Student student3 = new Student("12345680", "Indira", "Naidu");
    	
    	// Admits them to the University
    	this.admitStudent(student1);
    	this.admitStudent(student2);
    	this.admitStudent(student3);
    	
    	// Creates 3 units and adds them into unitArray
        unitArray.add(new Unit("FIT1234", "Advanced Bogosorts", this));
        unitArray.add(new Unit("FIT2027", "Introduction to Spaghetti Coding", this));
        unitArray.add(new Unit("FIT1237", "Enterprise Fizzbuzz", this));
        
	   	// A collection of assessments used when creating the assessment scheme for each unit
    	Set<Assessment> assessments = new LinkedHashSet<Assessment>();
    	
    	// Creates exams
    	// FIT 1234 Assessments
    	// Creates 3 assessments for FIT1234
    	Exam exam1 = new Exam(20, 32);
    	Exam exam2 = new Exam(30, 64);
    	Assignment assignment1 = new Assignment(50, "Developing an existing app but for a niche demographic");
    	// Adds 3 assessments to FIT1234
		assessments.add(exam1);
		assessments.add(exam2);
		assessments.add(assignment1);
        unitArray.get(0).setAssessmentScheme(assessments);
        
        // FIT 2027 Assessments
        assessments.clear();
        // Creates 3 assessments for FIT2027
    	Exam exam3 = new Exam(20, 64);
    	Exam exam4 = new Exam(30, 128);
    	Assignment assignment2 = new Assignment(50, "Finding out that most assignments involve pair programming");
        // Adds 3 assessments for FIT2027
		assessments.add(exam3);
		assessments.add(exam4);
    	assessments.add(assignment2);
        unitArray.get(1).setAssessmentScheme(assessments);

        // FIT 1237 Assessments
        assessments.clear();
        // Creates 3 assessments for FIT1237
    	Exam exam5 = new Exam(20, 128);
    	Exam exam6 = new Exam(30, 76);
    	Assignment assignment3 = new Assignment(50, "Writing a Bogosort Algorithm in machine code");
    	// Adds 3 assessments for FIT1237
		assessments.add(exam5);
		assessments.add(exam6);
		assessments.add(assignment3);
    	unitArray.get(2).setAssessmentScheme(assessments);
        
        // Enrols the students into the units created
        unitArray.get(0).enrolStudent(student1.getStudentId());
        unitArray.get(0).enrolStudent(student2.getStudentId());
        unitArray.get(1).enrolStudent(student3.getStudentId());
        unitArray.get(2).enrolStudent(student3.getStudentId());
        
        // Creates a few test marks to be used
        Mark mark1 = new Mark(100);
        Mark mark2 = new Mark(79);
        Mark mark3 = new Mark(51);
        Mark mark4 = new Mark(0);
        
        // Logs the marks for student1 in FIT 1234
        exam1.setStudentMark(student1.getStudentId(), mark2);
        exam2.setStudentMark(student1.getStudentId(), mark4);
        assignment1.setStudentMark(student1.getStudentId(), new Mark(0, "Could've gotten a higher mark somehow by not showing up"));
        
        // Logs the marks for student2 in FIT 1234
        exam1.setStudentMark(student2.getStudentId(), mark2);
        exam2.setStudentMark(student2.getStudentId(), mark2);
        assignment1.setStudentMark(student2.getStudentId(), mark2);
        
        // Logs the marks for student3 in FIT 2027
        exam3.setStudentMark(student3.getStudentId(), mark3);
        exam4.setStudentMark(student3.getStudentId(), mark3);
        assignment2.setStudentMark(student3.getStudentId(), mark3);
        
        // Logs the marks for student3 in FIT1237
		exam5.setStudentMark(student3.getStudentId(), new Mark(100, "Cheating is highly prohibited, you will be sent straight to maximum security prison without trial."));
		exam6.setStudentMark(student3.getStudentId(), mark1);
        assignment3.setStudentMark(student3.getStudentId(), mark1);
        
        // Tests 
        System.out.println();
        System.out.println(student1.description() + "'s marks for " + assignment1.description() + " is " + assignment1.getStudentMarks().get(student1.getStudentId()).getMark() + "%, comment: " + assignment1.getStudentMarks().get(student1.getStudentId()).getComment());
        System.out.println(student3.description() + "'s marks for " + exam5.description() + " is " + exam5.getStudentMarks().get(student3.getStudentId()).getMark() + "%, comment: " + exam5.getStudentMarks().get(student3.getStudentId()).getComment());
        // students 1 and 2 exam completion check
        System.out.println();
        System.out.println(student1.description() + " completed all exams in "+ unitArray.get(0).description() + "? " + unitArray.get(0).verifyAssessmentCompletion(student1.getStudentId()));
        System.out.println(student2.description() + " completed all exams in "+ unitArray.get(0).description() + "? " + unitArray.get(0).verifyAssessmentCompletion(student2.getStudentId()));
        System.out.println(student3.description() + " completed all exams in "+ unitArray.get(1).description() + "? " + unitArray.get(1).verifyAssessmentCompletion(student3.getStudentId()));
        System.out.println(student3.description() + " completed all exams in "+ unitArray.get(2).description() + "? " + unitArray.get(2).verifyAssessmentCompletion(student3.getStudentId()));
        // students 1 and 3 exam mark check for units FIT 1234 and FIT 1237
        System.out.println();
        System.out.println(student1.description() + "'s total marks for " + unitArray.get(0).description() + " is " + unitArray.get(0).getTotalMarks(student1.getStudentId()) + "%");
        System.out.println(student2.description() + "'s total marks for " + unitArray.get(0).description() + " is " + unitArray.get(0).getTotalMarks(student2.getStudentId()) + "%");
        System.out.println(student3.description() + "'s total marks for " + unitArray.get(1).description() + " is " + unitArray.get(1).getTotalMarks(student3.getStudentId()) + "%");
        System.out.println(student3.description() + "'s total marks for " + unitArray.get(2).description() + " is " + unitArray.get(2).getTotalMarks(student3.getStudentId()) + "%");       
        
        
        
        
        
        
        
        // TESTING COURSES FOR TASK 4
        Set<Unit> coreUnits1 = new HashSet<Unit>();
        
        coreUnits1.add(unitArray.get(1));
        
        Course course1 = new Course("Bachelor of Computer Engineering", coreUnits1, 1);
        courses.add(course1);
        
        Set<Unit> coreUnits2 = new HashSet<Unit>();
        
        coreUnits2.add(new Unit(unitArray.get(0)));
        coreUnits2.add(new Unit(unitArray.get(1)));
        
        Course course2 = new Course("Bachelor of Software Science", coreUnits2, 1);
        courses.add(course2);
        
        
        
        
        System.out.println("TEST HERE");
        //this.displayUnitIsCoreIn(unitArray.get(0));
        
        this.displayStudentsEligibleToGraduate();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        // Prompts the user to enter their student details
//        Student student4 = null;
//        student4 = new Student(this.readString("Please enter your student ID: "));
//        student4.setGivenName(this.readString("Please enter your given name: "));
//        student4.setFamilyName(this.readString("Please enter your family name: "));
//        this.admitStudent(student4);
//        unitArray.get(0).enrolStudent(student4.getStudentId());
    }
    
    /*
     * Function: Runs a loop that prints all units along with the students enrolled in it
     */
    public void displayUnits() {
        for(int i = 0; i < unitArray.size(); i++) {
            System.out.println();									// Prints new line
            System.out.println(unitArray.get(i).description());		// Prints units
            System.out.println("Entrolled Students: ");				
            displayEnrolledStudents(unitArray.get(i));				
        }
    }
    
    /*
     * Function: Prints all the students enrolled in the unit specified in the argument
     */
    public void displayEnrolledStudents(Unit unit) {
        for(int i = 0; i < unit.getEnrolledStudents().length; i++) {
    	    System.out.println(unit.getEnrolledStudents()[i].description());
    	}
    } 
    
    /*
     * Function: Prompts the user to input details and used the data read from the console
     * AUTHOR: Unknown, taken from FIT 2099 Java Bootcamp workshop - Week 3 File (Page 4)
     */
    private String readString(String prompt) {
        System.out.print(prompt);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = in.readLine();
    	} catch (IOException e) {
            e.printStackTrace();
    	}
        return s;
    }
    
    /*
     * Function: Admits the student to the current university
     */
    private void admitStudent(Student newStudent) {
        students.put(newStudent.getStudentId(), newStudent);
    }
    
    
    
    
    private Boolean isStudentEligibleToGraduate(Student student, Course course) {
    	int electivesPassed = 0;
    	int coreUnitsPassed = 0;
    	
        for (Unit unit : unitArray) {
        	if (unit.getTotalMarks(student.getStudentId()) > 50) {
				if (!isUnitCoreIn(unit, course)) {
					electivesPassed += 1;
				} else {
					coreUnitsPassed += 1;
				} 
			} else {
				if (isUnitCoreIn(unit, course)) {
					return false;
				}
			}
        }
        
        System.out.println("Electives Passed = " + electivesPassed);
        System.out.println("Core Units Passed = " + coreUnitsPassed);
        
        if (electivesPassed >= course.getRequiredElectives() && coreUnitsPassed != 0) {
        	return true;
        }
        return false;
        
    }
    
    private void displayStudentsEligibleToGraduate() {
    	
    	for (Course course : courses) {
    		HashSet<Student> eligibleStudents = new HashSet<Student>();
        	Iterator<Entry<String, Student>> studentIterator = students.entrySet().iterator();
    		while (studentIterator.hasNext()) {
    			Student student = new Student(studentIterator.next().getValue());
    			System.out.println(student.description());
    			if (isStudentEligibleToGraduate(student, course)) {
    				eligibleStudents.add(student);
    			}
    		}
    		System.out.println();
    		if (eligibleStudents.isEmpty()) {
    			System.out.println("No students are eligible to graduate in " + course.getCourseTitle());
    		} else {
    			System.out.println("Students eligible to graduate in " + course.getCourseTitle() + " are:");
    			for (Student eligibleStudent : eligibleStudents) {
    				System.out.println(eligibleStudent.description());
    			}
    		}
    		
    	}


    }
    
    
    
    
    
    private Boolean isUnitCoreIn(Unit unit, Course course) {
    	for(Unit courseUnit : course.getCoreUnits()) {
    		if (courseUnit.description().equals(unit.description())) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private void displayUnitIsCoreIn(Unit unit) {
    	Set<Course> courseSet = new HashSet<Course>();
    	// Adds courses the unit is core in to courseSet
    	for(Course course : courses) {
    		if (isUnitCoreIn(unit, course)) {
    			courseSet.add(course);
    		}
    	}
    	// Displays the courses the unit is core in, if Set courseSet is empty, method displays a different message
    	if (courseSet.isEmpty()) {
    		System.out.println("This unit is not a core unit in any of the courses offered in Java University.");
    	} else {
    		System.out.println("This unit is a core unit in: ");
        	for(Course courseName : courseSet) {
    			System.out.println(courseName.getCourseTitle());
        	}	
    	}
    }
    
   
    
}
