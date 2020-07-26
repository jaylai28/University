import java.util.LinkedHashSet;
import java.util.Set;

/*
 * Class Name: AssessmentScheme
 * Author: Wei Jian Lai
 */

public class AssessmentScheme {
	
	 /*--------------------------------------- Why use the Set Collection Class -----------------------------------------------
	 *  As there will be no duplicate exams or assignments, a set collection class would be optimum, where as LinkedHashSet is 
	 *  implemented as exams and assessments might need to be retrieved in an order.
	 * ----------------------------------------------------------------------------------------------------------------------- 
	 */
	// A linked hash set used to store a collection of Assessments
	private Set<Assessment> assessments = new LinkedHashSet<Assessment>();
	
	// Constructor to initialise the assessments set
	protected AssessmentScheme(Set<Assessment> newAssessment) {
		int total = 0;
		// The iterator used to look through the HashSet
    	for(Assessment assessment : newAssessment) {
    		total += assessment.getWeight();
    	}
    	if (total != 100) {
    		throw new IllegalArgumentException("Sum of all Assessment Weights should be 100");
    	}
		assessments.addAll(newAssessment);
	}
	
	// Returns a copy of the set of all the assessments 
	protected Set<Assessment> getAssessments() {
		return new AssessmentScheme(assessments).assessments;
	}
}
