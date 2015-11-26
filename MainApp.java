import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baseclass.Assignment;
import baseclass.Class;
import baseclass.Professor;
import baseclass.Semester;
import baseclass.TextBook;
import baseclass.Assignment.AssignmentType;

import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MainApp extends JFrame {
	private JPanel contentPane;
	private JComboBox<Semester> cmbSemester;
	private ArrayList<Semester> semesters = new ArrayList<>();
	private static DefaultComboBoxModel dcmSemester = new DefaultComboBoxModel<>();	
	private static DefaultComboBoxModel dcmClasses = new DefaultComboBoxModel<>();
	private static DefaultComboBoxModel dcmTextBooks = new DefaultComboBoxModel<>();
	private static DefaultComboBoxModel dcmAssignments = new DefaultComboBoxModel<>();
	private JTextField txtCName;
	private JTextField txtProfName;
	private JTextField txtProfEmail;
	private JTextField txtProfOffice;
	private JTextField txtProfOfficeHours;
	private JTextField txtProfPhone;
	private JTextField txtTxtName;
	private JTextField txtTxtAuth;
	private JTextField txtTxtYear;
	private JTextField txtTxtVol;
	private JTextField txtAssignName;
	private JTextField txtAssignType;
	private JTextField txtAssignDate;
	private JTextField txtDueDate;
	private JTextField txtGrade;
	public static DefaultComboBoxModel getSemesters() {
		return dcmSemester;
	}
	public static DefaultComboBoxModel getClasses() {
		return dcmClasses;
	}
	public static DefaultComboBoxModel getTextBooks() {
		return dcmTextBooks;
	}
	public static DefaultComboBoxModel getAssignments() {
		return dcmAssignments;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApp() {
		dcmSemester.addElement("");
		dcmClasses.addElement("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 450);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuCreate = new JMenu("Create");
		menuBar.add(menuCreate);
		
		JMenuItem menuCreateSemester = new JMenuItem("Create Semester");
		menuCreateSemester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == menuCreateSemester) {
					JFrame semester = new CreateSemester(new Callback<ArrayList<String>>() {
						public void call(ArrayList<String> param) {
							createSemester(param);
						}
						private void createSemester(ArrayList<String> param) {
							Semester s = new Semester(new ArrayList<Class>(), Integer.parseInt(param.get(0)), Semester.Season.valueOf(param.get(1).toUpperCase()));
							semesters.add(s);
							dcmSemester.addElement(s);
							cmbSemester.setModel(dcmSemester);
						}
					});
					semester.setVisible(true);
				}
			}
		});
		menuCreate.add(menuCreateSemester);
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox cmbTxtBook = new JComboBox();
		cmbTxtBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == cmbTxtBook && cmbTxtBook.getSelectedItem() != null) {
					TextBook t = (TextBook)cmbTxtBook.getSelectedItem();
					txtTxtName.setText(t.getBookName());
					txtTxtAuth.setText(t.getAuthor());
					txtTxtYear.setText(t.getYear());
					txtTxtVol.setText(t.getVolume());
				}
				else
				{
					txtTxtName.setText("");
					txtTxtAuth.setText("");
					txtTxtYear.setText("");
					txtTxtVol.setText("");
				}
			}
		});
		cmbTxtBook.setModel(dcmTextBooks);
		cmbTxtBook.setBounds(63, 198, 196, 20);
		
		JLabel lblClassName = new JLabel("Class Name:");
		lblClassName.setBounds(5, 39, 81, 14);
		contentPane.add(lblClassName);
		
		
		txtProfName = new JTextField();
		txtProfName.setEditable(false);
		txtProfName.setColumns(10);
		txtProfName.setBounds(165, 67, 177, 20);
		contentPane.add(txtProfName);
		
		txtProfEmail = new JTextField();
		txtProfEmail.setEditable(false);
		txtProfEmail.setColumns(10);
		txtProfEmail.setBounds(165, 92, 177, 20);
		contentPane.add(txtProfEmail);
		
		txtProfOffice = new JTextField();
		txtProfOffice.setEditable(false);
		txtProfOffice.setColumns(10);
		txtProfOffice.setBounds(165, 117, 177, 20);
		contentPane.add(txtProfOffice);
		
		txtProfOfficeHours = new JTextField();
		txtProfOfficeHours.setEditable(false);
		txtProfOfficeHours.setColumns(10);
		txtProfOfficeHours.setBounds(165, 142, 177, 20);
		contentPane.add(txtProfOfficeHours);
		
		txtProfPhone = new JTextField();
		txtProfPhone.setEditable(false);
		txtProfPhone.setColumns(10);
		txtProfPhone.setBounds(165, 167, 177, 20);
		contentPane.add(txtProfPhone);
		
		txtTxtAuth = new JTextField();
		txtTxtAuth.setEditable(false);
		txtTxtAuth.setColumns(10);
		txtTxtAuth.setBounds(63, 254, 196, 20);
		contentPane.add(txtTxtAuth);
		
		txtTxtYear = new JTextField();
		txtTxtYear.setEditable(false);
		txtTxtYear.setColumns(10);
		txtTxtYear.setBounds(63, 279, 196, 20);
		contentPane.add(txtTxtYear);
		
		txtTxtVol = new JTextField();
		txtTxtVol.setEditable(false);
		txtTxtVol.setColumns(10);
		txtTxtVol.setBounds(63, 304, 196, 20);
		contentPane.add(txtTxtVol);
		
		txtCName = new JTextField();
		txtCName.setEditable(false);
		txtCName.setBounds(165, 36, 177, 20);
		contentPane.add(txtCName);
		txtCName.setColumns(10);
		
		cmbSemester = new JComboBox();
		cmbSemester.setBounds(5, 8, 212, 20);
		contentPane.add(cmbSemester);
		JComboBox cmbClasses = new JComboBox();		

		
		JMenuItem menuCreateTextbook = new JMenuItem("Create Textbook");
		menuCreateTextbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbClasses.getItemCount() < 1) {
					JOptionPane.showMessageDialog(contentPane, "You must create a class before adding a text book.");
					return;
				}
				if (e.getSource() == menuCreateTextbook) {
					JFrame textbook = new CreateTextbook(new Callback<ArrayList<String>>() {
						public void call(ArrayList<String> param) {
							createTextbook(param);
						}
						private void createTextbook(ArrayList<String> param) {
							Class c = ((Class)cmbClasses.getSelectedItem());
							TextBook t = new TextBook(param.get(0), param.get(1), param.get(2), param.get(3));
							c.getTextBooks().add(t);
							dcmTextBooks.addElement(t);
						}
					});
					textbook.setVisible(true);
				}
			}
		});
		menuCreate.add(menuCreateTextbook);
		
		JMenuItem menuCreateClass = new JMenuItem("Create Class");
		menuCreateClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == menuCreateClass) {
					if (cmbSemester.getItemCount() < 1) {
						JOptionPane.showMessageDialog(contentPane, "You must create a semester before adding a class.");
						return;
					}
					JFrame newClass = new CreateClass(new Callback<ArrayList<String>>() {
						public void call(ArrayList<String> param) {
							CreateClass(param);
						}
						private void CreateClass(ArrayList<String> param) {
							Class c = new Class(param.get(0), new ArrayList<TextBook>(), new ArrayList<Assignment>(), new Professor(param.get(1), param.get(2), param.get(3), param.get(4), param.get(5)), 0);
							((Semester)cmbSemester.getSelectedItem()).getClassName().add(c);
							dcmClasses.addElement(c);
						}
					});
					newClass.setVisible(true);
				}
			}
		});

		menuCreate.add(menuCreateClass);

		contentPane.add(cmbTxtBook);
		
		JLabel lblNewLabel = new JLabel("Professor Name:");
		lblNewLabel.setBounds(5, 70, 133, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblProfessorEmail = new JLabel("Professor Email:");
		lblProfessorEmail.setBounds(5, 95, 133, 14);
		contentPane.add(lblProfessorEmail);
		
		JLabel lblProfessorOffice = new JLabel("Professor Office:");
		lblProfessorOffice.setBounds(5, 120, 133, 14);
		contentPane.add(lblProfessorOffice);
		
		JLabel lblProfessorOfficeHours = new JLabel("Professor Office Hours:");
		lblProfessorOfficeHours.setBounds(5, 145, 168, 14);
		contentPane.add(lblProfessorOfficeHours);
		
		JLabel lblProfessorPhone = new JLabel("Professor Phone:");
		lblProfessorPhone.setBounds(5, 170, 133, 14);
		contentPane.add(lblProfessorPhone);
		
		JLabel lblNewLabel_1 = new JLabel("Textbook:");
		lblNewLabel_1.setBounds(5, 204, 147, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(5, 232, 133, 14);
		contentPane.add(lblName);
		
		txtTxtName = new JTextField();
		txtTxtName.setEditable(false);
		txtTxtName.setColumns(10);
		txtTxtName.setBounds(63, 229, 196, 20);
		contentPane.add(txtTxtName);
		
		JLabel lblVol = new JLabel("Volume:");
		lblVol.setBounds(5, 307, 133, 14);
		contentPane.add(lblVol);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(5, 282, 133, 14);
		contentPane.add(lblYear);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(5, 257, 133, 14);
		contentPane.add(lblAuthor);
		
		JLabel lblAssignments = new JLabel("Assignment:");
		lblAssignments.setBounds(296, 204, 81, 14);
		contentPane.add(lblAssignments);
		
		JLabel lblGpa = new JLabel("Semester GPA:");
		lblGpa.setBounds(476, 11, 89, 14);
		contentPane.add(lblGpa);
		
		JLabel lblGPA = new JLabel("");
		lblGPA.setBounds(591, 11, 46, 14);
		contentPane.add(lblGPA);	
		
		
		JComboBox cmbAssign = new JComboBox();
		cmbAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == cmbAssign && cmbAssign.getSelectedItem() != null) {
					Assignment a = (Assignment)cmbAssign.getSelectedItem();
					String text = "";
					switch (a.getAssignmentType()) {
					case HW: 
						text = "Homework";
						break;
					case QUIZ:
						text = "Quiz";
						break;
					case INCLASS:
						text = "In-class";
						break;
					case EXAM:
						text = "Exam";
						break;
					}
					txtAssignName.setText(a.getName());
					txtAssignType.setText(text);
					txtAssignDate.setText(a.getAssignedDate());
					txtDueDate.setText(a.getDueDate());
					txtGrade.setText(Double.toString(a.getGrade()));
					//lblGPA.setText(Double.toString(calcGPA(cmbClasses)));
				}
				else {
					txtAssignName.setText("");
					txtAssignType.setText("");
					txtAssignDate.setText("");
					txtDueDate.setText("");
					txtGrade.setText("");
					//lblGPA.setText(Double.toString(calcGPA(cmbClasses)));
				}
					
			}
		});
		cmbAssign.setBounds(384, 198, 196, 20);
		contentPane.add(cmbAssign);
		cmbAssign.setModel(dcmAssignments);
		
		JLabel label = new JLabel("Name:");
		label.setBounds(296, 232, 133, 14);
		contentPane.add(label);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(296, 257, 133, 14);
		contentPane.add(lblType);
		
		JLabel lblAssignDate = new JLabel("Assign Date:");
		lblAssignDate.setBounds(296, 282, 133, 14);
		contentPane.add(lblAssignDate);
		
		JLabel lblDueDate = new JLabel("Due Date:");
		lblDueDate.setBounds(296, 307, 133, 14);
		contentPane.add(lblDueDate);
		
		JLabel lblGrade = new JLabel("Grade:");
		lblGrade.setBounds(296, 332, 133, 14);
		contentPane.add(lblGrade);
		
		txtAssignName = new JTextField();
		txtAssignName.setEditable(false);
		txtAssignName.setColumns(10);
		txtAssignName.setBounds(384, 229, 196, 20);
		contentPane.add(txtAssignName);
		
		txtAssignType = new JTextField();
		txtAssignType.setEditable(false);
		txtAssignType.setColumns(10);
		txtAssignType.setBounds(384, 254, 196, 20);
		contentPane.add(txtAssignType);
		
		txtAssignDate = new JTextField();
		txtAssignDate.setEditable(false);
		txtAssignDate.setColumns(10);
		txtAssignDate.setBounds(384, 279, 196, 20);
		contentPane.add(txtAssignDate);
		
		txtDueDate = new JTextField();
		txtDueDate.setEditable(false);
		txtDueDate.setColumns(10);
		txtDueDate.setBounds(384, 304, 196, 20);
		contentPane.add(txtDueDate);
		
		txtGrade = new JTextField();
		txtGrade.setEditable(false);
		txtGrade.setColumns(10);
		txtGrade.setBounds(384, 332, 196, 20);
		contentPane.add(txtGrade);
		


		cmbClasses.setBounds(227, 8, 232, 20);
		contentPane.add(cmbClasses);
		cmbClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbClasses.getSelectedItem() != null) {
					txtCName.setText(cmbClasses.getSelectedItem().toString());
					dcmTextBooks.removeAllElements();
					dcmAssignments.removeAllElements();
					Class c = ((Class)cmbClasses.getSelectedItem());
					for (int i = 0; i < (c.getTextBooks()).size(); i++) {
						dcmTextBooks.addElement(c.getTextBooks().get(i));
					}
					for (int i = 0; i < c.getAssignments().size(); i++) {
						dcmAssignments.addElement(c.getAssignments().get(i));
					}
					
					txtProfName.setText(c.getProfessor().getName());
					txtProfEmail.setText(c.getProfessor().getEmail());
					txtProfOffice.setText(c.getProfessor().getOffice());
					txtProfOfficeHours.setText(c.getProfessor().getOfficeHours());
					txtProfPhone.setText(c.getProfessor().getPhoneNumber());
				}
				else {
					txtCName.setText("");
					txtProfName.setText("");
					txtProfEmail.setText("");
					txtProfOffice.setText("");
					txtProfOfficeHours.setText("");
					txtProfPhone.setText("");
				}				
			}
		});
		lblGPA.setText(Double.toString(calcGPA(cmbClasses)));
		
		JLabel lblTotalGpa = new JLabel("Total GPA: ");
		lblTotalGpa.setBounds(476, 39, 89, 14);
		contentPane.add(lblTotalGpa);
		
		JLabel lblTotGPA = new JLabel("0.0");
		lblTotGPA.setBounds(591, 39, 46, 14);
		lblTotGPA.setText(Double.toString(calcTotGPA(semesters)));
		contentPane.add(lblTotGPA);
		
		
		cmbSemester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == cmbSemester && !cmbSemester.getSelectedItem().equals("") && cmbSemester.getSelectedItem() != null) {
					dcmClasses.removeAllElements();
					dcmAssignments.removeAllElements();
					dcmTextBooks.removeAllElements();
					Object o = cmbSemester.getSelectedItem();
					for (int i = 0; i < ((Semester)o).getClassName().size(); i++) {
						dcmClasses.addElement(((Semester)o).getClassName().get(i));
					}
					lblTotGPA.setText(Double.toString(calcTotGPA(semesters)));
					lblGPA.setText(Double.toString(calcGPA(cmbClasses)));
					cmbClasses.setModel(dcmClasses);
					}
				else {
					txtTxtName.setText("");
					txtTxtAuth.setText("");
					txtTxtYear.setText("");
					txtTxtVol.setText("");
					txtCName.setText("");
					txtProfName.setText("");
					txtProfEmail.setText("");
					txtProfOffice.setText("");
					txtProfOfficeHours.setText("");
					txtProfPhone.setText("");
					txtAssignName.setText("");
					txtAssignType.setText("");
					txtAssignDate.setText("");
					txtDueDate.setText("");
					txtGrade.setText("");
					dcmTextBooks.removeAllElements();
					dcmClasses.removeAllElements();
					dcmAssignments.removeAllElements();
					lblTotGPA.setText(Double.toString(calcTotGPA(semesters)));
					lblGPA.setText(Double.toString(calcGPA(cmbClasses)));
				}
			}
		});
		
		JMenuItem menuCreateAssign = new JMenuItem("Create Assignment");
		menuCreateAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == menuCreateAssign) {
					if (cmbClasses.getItemCount() < 1) {
						JOptionPane.showMessageDialog(contentPane, "You must create a class before adding an assignment.");
						return;
					}
					JFrame assignment = new CreateAssignment(new Callback<ArrayList<String>>() {
						public void call(ArrayList<String> param) {
							CreateAssignment(param);
						}
						private void CreateAssignment(ArrayList<String> param) {
							Class c = ((Class)cmbClasses.getSelectedItem());
							
							Assignment a = new Assignment(param.get(0), param.get(1), param.get(2), Double.parseDouble(param.get(3)), Assignment.AssignmentType.valueOf(param.get(4)));
							c.getAssignments().add(a);
							dcmAssignments.addElement(a);
							lblGPA.setText(Double.toString(calcGPA(cmbClasses)));
							lblTotGPA.setText(Double.toString(calcTotGPA(semesters)));
						}
					});
					assignment.setVisible(true);
				}
			}
		});
		menuCreate.add(menuCreateAssign);
		
		JMenu mnRemove = new JMenu("Remove");
		menuBar.add(mnRemove);
		
		JMenuItem menuDeleteSem = new JMenuItem("Delete Semester");
		mnRemove.add(menuDeleteSem);
		
		JMenuItem menuDeleteClass = new JMenuItem("Delete Class");
		menuDeleteClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == menuDeleteClass && cmbClasses.getSelectedItem() != null) {
					DeleteClass delClass = new DeleteClass(new Callback<Object>() {
						public void call(Object param) {
							deleteClass(param);
						}
						private void deleteClass(Object param) {
							dcmClasses.removeElement(param);
							((Semester)cmbSemester.getSelectedItem()).getClassName().remove(param);
							lblGPA.setText(Double.toString(calcGPA(cmbClasses)));
							lblTotGPA.setText(Double.toString(calcTotGPA(semesters)));
						}
					});
					delClass.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(contentPane, "There are no classes to delete.");
			}
		});
		mnRemove.add(menuDeleteClass);
		
		JMenuItem menuAssignment = new JMenuItem("Delete Assignment");
		menuAssignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == menuAssignment && cmbAssign.getSelectedItem() != null) {
					DeleteAssignment delClass = new DeleteAssignment(new Callback<Object>() {
						public void call(Object param) {
							deleteAssignment(param);
						}
						private void deleteAssignment(Object param) {
							((Class)cmbClasses.getSelectedItem()).getAssignments().remove(param);
							dcmAssignments.removeElement(param);
							lblGPA.setText(Double.toString(calcGPA(cmbClasses)));
						}
					});
					delClass.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(contentPane, "There are no assignments to delete.");
			}
		});
		
		mnRemove.add(menuAssignment);
		
		JMenuItem menuDeleteText = new JMenuItem("Delete Textbook");
		menuDeleteText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == menuDeleteText && cmbTxtBook.getSelectedItem() != null) {
					DeleteTextBook delClass = new DeleteTextBook(new Callback<Object>() {
						public void call(Object param) {
							deleteTextBook(param);
						}
						private void deleteTextBook(Object param) {
							((Class)cmbClasses.getSelectedItem()).getTextBooks().remove(param);
							dcmTextBooks.removeElement(param);
							lblGPA.setText(Double.toString(calcGPA(cmbClasses)));
						}
					});
					delClass.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(contentPane, "There are no textbooks to delete.");
			}
		});
		mnRemove.add(menuDeleteText);
		
		JMenu menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		JMenuItem menuEditSemester = new JMenuItem("Edit Semester");
		menuEditSemester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == menuEditSemester && cmbSemester.getSelectedItem() != null) {
					EditSemester edit = new EditSemester(new Callback<Object>() {
						public void call(Object param) {
							editSemester(param);
						}
						private void editSemester(Object param) {
						}
					});
					edit.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(contentPane, "There are no semesters to delete.");
			}
		});
		
	
		menuEdit.add(menuEditSemester);

		menuDeleteSem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == menuDeleteSem && cmbSemester.getSelectedItem() != null) {
					DeleteSemester delSem = new DeleteSemester(new Callback<Object>() {
						public void call(Object param) {
							deleteSemester(param);
						}
						private void deleteSemester(Object param) {
							dcmSemester.removeElement(param);
							lblGPA.setText(Double.toString(calcGPA(cmbClasses)));
						}
					});
					delSem.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(contentPane, "There are no semesters to delete.");
			}
		});
		
	}
	public double calcGPA(JComboBox cb) {
		int count = 0;
		double sum = 0;
		for (int i = 0; i < cb.getItemCount(); i++) {
			Class c = (Class)cb.getItemAt(i);
			ArrayList<Assignment> a = c.getAssignments();
			for (Assignment assign : a) {
				sum += assign.getGrade();
				count++;
			}
		}
		if (sum == 0 || count == 0)
			return 0.0;
		return sum / count;
	}
	public double calcTotGPA(ArrayList<Semester> s) {
		double sum = 0;
		int count = 0;
		for (Semester sem : s) {
			ArrayList<Class> classes = sem.getClassName();
			for (Class c : classes) {
				for (Assignment a : c.getAssignments()) {
					sum += a.getGrade();
					count++;
				}
			}
		}
		if (sum == 0 || count == 0)
			return 0.0;
		return sum / count;
	}
}
