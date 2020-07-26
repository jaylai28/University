/**
 * Implements the Assignment class which is a subclass of Assessment. This class stores the assignment's title and sets the assignment weightage using a constructor.
 * 
 * @author Wei Jian Lai
 */
public class Assignment extends Assessment{
	
	/** A string representing the assignment's title. */
	private String title;
	
	/** 
	 * Constructor for the assignment class .
	 * 
	 * @param newWeight An assignment weightage that can range from 1 to 100.
	 * @param newTitle The assignment title.
	 */
	public Assignment(int newWeight, String newTitle) {
		this.setWeight(newWeight);
		title = newTitle;
	}
	
	/**
	 *  Prints out a description for the current assignment based on the weight and title attributes.
	 *  
	 *  @return A string containing the description describing the key properties of the assignment.
	 */
	protected String description() {
		return "Assignment: " + title + ", weight " + this.getWeight() + "%";
	}
}


