package baseclass;
import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable {
	private static final long serialVersionUID = -2338921038578165349L;
	private String className;
	private ArrayList<TextBook> textBooks;
	private ArrayList<Assignment> assignments;
	private Professor professor;
	/**
	 * 
	 * @param className name of the class
	 * @param textBooks each class contains an arraylist of textbooks with publisher information
	 * @param assignments each class contains an arraylist of assignments with relevant information to each assignment
	 * @param professor is an object which contains all information related to a professor
	 */
	public Class(String className, ArrayList<TextBook> textBooks, ArrayList<Assignment> assignments, Professor professor){
		this.className = className;
		this.textBooks = textBooks;
		this.assignments = assignments;
		this.professor = professor;
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
	public String toString() {
		return className;
	}
}
