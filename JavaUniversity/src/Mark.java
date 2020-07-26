/**
 * Implements the Mark class which stores the a mark along with an optional comment.
 * 
 * @author Wei Jian Lai
 */
public class Mark{
	
	/** Stores the Mark as an integer ranging from 0 to 100. */
	private int numericalMark;
	/** Stores an optional comment string. */
	private String comment;
	
	/**
	 * Constructor for Mark with 2 parameters: newNumericalMark and newComment.
	 * 
	 * @param newNumericalMark An integer that can range from 0 to 100.
	 * @param newComment A string of a written remark expressing an opinion or reaction.
	 * @throws IllegalArgumentException When the mark entered is not within the valid range.
	 */
	protected Mark(int newNumericalMark, String newComment) {
		if (newNumericalMark < 0 || newNumericalMark > 100) {
			throw new IllegalArgumentException("Marks can only range from 0 to 100");
		}
		numericalMark = newNumericalMark;
		comment = newComment;
	}
	
	/**
	 * Constructor used to initiate the numerical marks only.
	 * @param newNumericalMark An integer that can range from 0 to 100.
	 * @throws IllegalArgumentException When the mark entered is not within the valid range.
	 */
	protected Mark(int newNumericalMark) {
		if (newNumericalMark < 0 || newNumericalMark > 100) {
			throw new IllegalArgumentException("Marks can only range from 0 to 100");
		}		
		numericalMark = newNumericalMark;
	}
	
	/**
	 * Copy constructor for class Mark. 
	 *
	 * @param mark A Mark object which is used in the constructor to create a separate instance of Mark.
	 * @throws IllegalArgumentException When the mark entered is not within the valid range.
	 */
	protected Mark(Mark mark) {
		if (mark.numericalMark < 0 || mark.numericalMark > 100) {
			throw new IllegalArgumentException("Marks can only range from 0 to 100");
		}
		numericalMark = mark.numericalMark;
		comment = mark.comment;
	}
	
	/**
	 * Accessor: Gets the numerical mark of the assessment.
	 * 
	 * @return An integer value of the numericalMark attribute.
	 */
	protected int getMark() {
		return numericalMark;
	}
	
	/**
	 * Accessor: Gets the comment based on the assessment.
	 * 
	 * @return A string containing the comment attribute.
	 */
	protected String getComment() {
		return comment;
	}
	
	/**
	 * Mutator: Sets the numerical mark to a different value.
	 * 
	 * @param newNumericalMark An integer that can range from 0 to 100.
	 */
	protected void setMark(int newNumericalMark) {
		numericalMark = newNumericalMark;
	}
	
	/**
	 * Mutator: Sets the comments to a different value.
	 * 
	 * @param newComment A string of a written remark expressing an opinion or reaction.
	 */
	protected void setComment(String newComment) {
		comment = newComment;
	}
}
