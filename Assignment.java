import java.util.Date;

public class Assignment {
	public enum AssignmentType {
		HW,
		INCLASS,
		EXAM,
		QUIZ
	}
	private Date dueDate;
	private Date assignedDate;
	private double grade;
	private AssignmentType assignmentType;
	
	public Assignment(Date assignedDate, Date dueDate, double grade, AssignmentType assignmentType) {
		this.setAssignmentType(assignmentType);
		this.setAssignedDate(new Date()); // default current date is assigned at time of creation.
		this.setDueDate(dueDate);
		this.setGrade(grade);
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
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
	
	
	
}
