package baseclass;
import java.io.Serializable;
import java.util.Date;

public class Assignment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2565432062078001763L;
	public enum AssignmentType {
		HW,
		INCLASS,
		EXAM,
		QUIZ
	}
	private String name;
	private String dueDate;
	private String assignedDate;
	private double grade;
	private AssignmentType assignmentType;
	
	public Assignment(String name, String assignedDate, String dueDate, double grade, AssignmentType assignmentType) {
		this.assignmentType = assignmentType;
		this.assignedDate = assignedDate;
		this.dueDate = dueDate;
		this.grade = grade;
		this.setName(name);
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
	
	
}
