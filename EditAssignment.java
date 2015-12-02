import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import baseclass.Class;
import baseclass.Assignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditAssignment extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtGrade;
	private JTextField txtDueDate;
	private JTextField txtAssignDate;
	private JLabel lblSemesterSelection;

	/**
	 * This class is responsible for editing an assignment
	 * @param callback creates a callback to the main frame if needed to pass information forward
	 * 
	 */
	public EditAssignment(final Callback<Object> callback) {
		DefaultComboBoxModel dcmClasses = MainApp.getClasses();
		DefaultComboBoxModel dcmSemester = MainApp.getSemesters();
		DefaultComboBoxModel dcmAssign = MainApp.getAssignments();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAssignmentName = new JLabel("Assignment Name:");
		lblAssignmentName.setBounds(10, 11, 124, 14);
		contentPane.add(lblAssignmentName);
		
		JLabel lblAssignmentType = new JLabel("Assignment Type:");
		lblAssignmentType.setBounds(10, 36, 124, 14);
		contentPane.add(lblAssignmentType);
		
		JLabel lblAssignmentGrade = new JLabel("Assignment Grade:");
		lblAssignmentGrade.setBounds(10, 61, 124, 14);
		contentPane.add(lblAssignmentGrade);
		
		JLabel lblAssignmentDueDate = new JLabel("Assignment Due Date:");
		lblAssignmentDueDate.setBounds(10, 86, 169, 14);
		contentPane.add(lblAssignmentDueDate);
		
		JLabel lblAssignmentAssignedDate = new JLabel("Assignment Assigned Date:");
		lblAssignmentAssignedDate.setBounds(10, 111, 169, 14);
		contentPane.add(lblAssignmentAssignedDate);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(309, 151, 89, 23);
		contentPane.add(btnSubmit);
		
		txtName = new JTextField();
		txtName.setBounds(189, 5, 209, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtGrade = new JTextField();
		txtGrade.setColumns(10);
		txtGrade.setBounds(189, 58, 209, 20);
		contentPane.add(txtGrade);
		
		txtDueDate = new JTextField();
		txtDueDate.setColumns(10);
		txtDueDate.setBounds(189, 83, 209, 20);
		contentPane.add(txtDueDate);
		
		txtAssignDate = new JTextField();
		txtAssignDate.setColumns(10);
		txtAssignDate.setBounds(189, 108, 209, 20);
		contentPane.add(txtAssignDate);
		
		lblSemesterSelection = new JLabel("Semester Selection");
		lblSemesterSelection.setBounds(452, 11, 138, 14);
		contentPane.add(lblSemesterSelection);
		
		JComboBox cmbSemester = new JComboBox();
		cmbSemester.setBounds(452, 33, 173, 20);
		contentPane.add(cmbSemester);
		cmbSemester.setModel(dcmSemester);
		
		JLabel lblClassSelection = new JLabel("Class Selection");
		lblClassSelection.setBounds(452, 61, 116, 14);
		contentPane.add(lblClassSelection);
		
		JComboBox cmbClasses = new JComboBox();
		cmbClasses.setBounds(452, 83, 173, 20);
		contentPane.add(cmbClasses);
		cmbClasses.setModel(dcmClasses);
		
		JLabel lblAssignmentSelection = new JLabel("Assignment Selection");
		lblAssignmentSelection.setBounds(452, 114, 148, 14);
		contentPane.add(lblAssignmentSelection);
		
		DefaultComboBoxModel dcmAssignType = new DefaultComboBoxModel();
		dcmAssignType.addElement("HW");
		dcmAssignType.addElement("INCLASS");
		dcmAssignType.addElement("EXAM");
		dcmAssignType.addElement("QUIZ");
		JComboBox cmbAssign = new JComboBox();
		cmbAssign.setBounds(452, 137, 173, 20);
		contentPane.add(cmbAssign);
		cmbAssign.setModel(dcmAssign);
		
		JComboBox cmbAssignType = new JComboBox();
		cmbAssignType.setBounds(189, 33, 209, 20);
		cmbAssignType.setModel(dcmAssignType);
		contentPane.add(cmbAssignType);
		
		cmbAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbAssign.getSelectedItem() instanceof Assignment) {
					Assignment a = (Assignment)cmbAssign.getSelectedItem();
					txtName.setText(a.getName());
					txtGrade.setText(Double.toString(a.getGrade()));
					txtDueDate.setText(a.getDueDate());
					txtAssignDate.setText(a.getAssignedDate());
					cmbAssignType.setSelectedItem(a.getAssignmentType().toString());
				}
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbAssign.getSelectedItem() instanceof Assignment) {
					Assignment a = (Assignment)cmbAssign.getSelectedItem();
					a.setAssignedDate(txtAssignDate.getText());
					a.setAssignmentType(Assignment.AssignmentType.valueOf((String)cmbAssignType.getSelectedItem()));
					a.setDueDate(txtDueDate.getText());
					if (Validation.isDouble(txtGrade.getText()))
						a.setGrade(Double.parseDouble(txtGrade.getText()));
					else {
						JOptionPane.showMessageDialog(contentPane, "Please enter a valid grade (integer-only or double only)");
						return;
					}
					a.setName(txtName.getText());
					callback.call(cmbAssign.getSelectedItem());
					dispose();
				}
			}
		});
		
		if (cmbAssign.getSelectedItem() instanceof Assignment) {
			Assignment a = (Assignment)cmbAssign.getSelectedItem();
			txtName.setText(a.getName());
			txtGrade.setText(Double.toString(a.getGrade()));
			txtDueDate.setText(a.getDueDate());
			txtAssignDate.setText(a.getAssignedDate());
			cmbAssignType.setSelectedItem(a.getAssignmentType().toString());
		}
	}
}
