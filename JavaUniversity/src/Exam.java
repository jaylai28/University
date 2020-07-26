
/**
 * Implements the Exam class which is a subclass of Assessment. This class stores the exam's duration and sets the exam's weightage using a constructor.
 * @author Wei Jian Lai
 *
 */
public class Exam extends Assessment{
	
	/** The exam's duration that lasts anywhere from 30 minutes to 180. */
	private int duration;
	
	/** 
	 * Constructor for the class exam. 
	 * 
	 * @param newWeight An exam weightage that can range from 1 to 100.
	 * @param newDuration The exam's duration that can range from 30 to 180.
	 * @throws IllegalArgumentException When newDuration is set to less than 30 or more than 180 or when the newWeight is being set to a value less than 1 or more than 100.
	 * 
	 */
	public Exam(int newWeight, int newDuration) {
		this.setWeight(newWeight);
		if (newDuration < 30) {
			throw new IllegalArgumentException("Exam duration too short.");
		} else if (newDuration > 180) {
			throw new IllegalArgumentException("Exam duration too long.");
		}
		duration = newDuration;
	}
	
	/**
	 *  Prints out a description for the current exam based on the weight and duration attributes.
	 *  
	 *  @return A string containing the description describing the key properties of the exam.
	 */
	protected String description() {
		return "Exam: duration " + duration + " minutes, weight " + this.getWeight() + "%";
	}
	
}
