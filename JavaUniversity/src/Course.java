import java.util.HashSet;
import java.util.Set;

/*
 * Class Name: Course
 * Author: Wei Jian Lai
 */

public class Course {
    private String courseTitle;
    private Set<Unit> coreUnits = new HashSet<Unit>();
    private int requiredElectives;
    
    
    
    public Course(String newCourseTitle, Set<Unit> newCoreUnits, int newRequiredElectives) {
    	if (newCoreUnits.size() < 1) {
    		throw new IllegalArgumentException("Course must contain at least 1 core Unit");
    	}
    	courseTitle = newCourseTitle;
    	coreUnits.addAll(newCoreUnits);
    	requiredElectives = newRequiredElectives;
    }
    
    protected String getCourseTitle() {
    	return courseTitle;
    }
    
    protected Set<Unit> getCoreUnits() {
    	Set<Unit> coreUnitList = new HashSet<Unit>();
    	for (Unit unit : coreUnits) {
    		coreUnitList.add(new Unit(unit));
    	}
    	return coreUnitList;
    }
    
    
    
    protected int getRequiredElectives() {
    	return requiredElectives;
    }
  
}
