package baseclass;
import java.util.ArrayList;

public class Class {
	private String className;
	private ArrayList<TextBook> textBooks;
	private ArrayList<Assignment> assignments;
	private Professor professor;
	private int totalGrade;
	public Class(String className, ArrayList<TextBook> textBooks, ArrayList<Assignment> assignments, Professor professor, int totalGrade){
		this.className = className;
		this.textBooks = textBooks;
		this.assignments = assignments;
		this.professor = professor;
		this.totalGrade = totalGrade;
		}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public ArrayList<TextBook> getTextBooks() {
		return textBooks;
	}
	public void setTextBooks(ArrayList<TextBook> textBooks) {
		this.textBooks = textBooks;
	}
	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}
	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public int getTotalGrade() {
		return totalGrade;
	}
	public void setTotalGrade(int totalGrade) {
		this.totalGrade = totalGrade;
	}
	public String toString() {
		return className;
	}
}
