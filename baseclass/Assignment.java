package baseclass;
import java.io.Serializable;
import java.util.HashMap;

public class Assignment implements Serializable {
	private static final long serialVersionUID = 2565432062078001763L;
	/**
	 * 
	 * Enumeration that contains the different types of assignments
	 *
	 */
	public enum AssignmentType {
		HW,
		INCLASS,
		EXAM,
		QUIZ,
	}
	private String name;
	private String dueDate;
	private String assignedDate;
	private double grade;
	private AssignmentType assignmentType;
	private double weight;
	public static HashMap<AssignmentType, Double> weightValues = new HashMap<>();
	/**
	 * Initializes all values in hashmap weightValues, called within main class, default weights are 1.0
	 */
	public static void initialize() {
		weightValues.put(AssignmentType.HW, 1.0);
		weightValues.put(AssignmentType.INCLASS, 1.0);
		weightValues.put(AssignmentType.EXAM, 1.0);
		weightValues.put(AssignmentType.QUIZ, 1.0);
	}
	/**
	 * 
	 * @param name this represents the name given to an assignment, e.g. "HW 1"
	 * @param assignedDate this is a string that represents when the assignment was assigned.
	 * @param dueDate this is a string that represents when the assignment is due.
	 * @param grade this is the grade assigned to the assignment.
	 * @param assignmentType this is the type of assignment, HW, INCLASS, EXAM, or QUIZ
	 */
	public Assignment(String name, String assignedDate, String dueDate, double grade, AssignmentType assignmentType) {
		this.assignmentType = assignmentType;
		this.assignedDate = assignedDate;
		this.dueDate = dueDate;
		this.grade = grade;
		this.name = name;
	}

	public String getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public AssignmentType getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(AssignmentType assignmentType) {
		this.assignmentType = assignmentType;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}

	public double getWeight() {
		return weightValues.get(this.assignmentType);
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public HashMap<AssignmentType, Double> getWeightValues() {
		return weightValues;
	}

	public void setWeightValues(HashMap<AssignmentType, Double> weightValues) {
		Assignment.weightValues = weightValues;
	}
	
	
}
