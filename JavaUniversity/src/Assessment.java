import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * Implements the Assessment abstract class which is used to store the weightage of each assessments along with the student marks.
 * 
 * @author Wei Jian Lai
 */
public abstract class Assessment {
	
	/** Stores the weightage carried in each assessment. */
	private int weight;
	/** Stores the student's mark for each assessment with the student's ID acting as a key */
	private HashMap<String, Mark> studentMarks = new HashMap<String, Mark>();
	
	/**
	 * Accessor: Retrieves the weight of the assessment as an integer.
	 * 
	 * @return The value of the assessment weightage.
	 */
	protected int getWeight() {
		return weight;
	}
	
	/**
	 * Accessor: Retrieves a collection student marks with the student's ID acting as a key.
	 * 
	 * @return A HashMap containing a key-value pair of each of the student's marks.
	 */
	protected HashMap<String, Mark> getStudentMarks() {
		HashMap<String, Mark> studentMarksCopy = new HashMap<String, Mark>();
		Iterator<Entry<String, Mark>> marksIterator = studentMarks.entrySet().iterator();
		while (marksIterator.hasNext()) {
			Entry<String, Mark> marks = marksIterator.next();
			studentMarksCopy.put(marks.getKey(), new Mark(marks.getValue()));
		}
		return studentMarksCopy;
	}
	
	
	/**
	 * Mutator: Sets the weight of the assessment.
	 * 
	 * @param newWeight An assessment weightage that can range from 1 to 100.
	 * @throws IllegalArgumentException When the newWeight is being set to a value less than 1 or more than 100.
	 */
	protected void setWeight(int newWeight) {
		if (newWeight < 1) {
			throw new IllegalArgumentException("Assessment weight too small");
		} else if (newWeight > 100) {
			throw new IllegalArgumentException("Assessment weight too large");
		}
		weight = newWeight;
	}
	
	/**
	 * Mutator: Sets the student mark of the assessment.
	 * 
	 * @param studentId An 8 digit student ID.
	 * @param studentMark Mark the student scored out of 100.
	 */
	protected void setStudentMark(String studentId, Mark studentMark) {
		studentMarks.put(studentId, new Mark(studentMark));
	}
	
	/** 
	 * Abstract method for description.
	 * 
	 * @return A string describing the key properties of the assessment.
	 */
	protected abstract String description();
}
