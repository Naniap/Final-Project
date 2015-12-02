import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baseclass.Assignment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateAssignment extends JFrame {

	private JPanel contentPane;
	private JTextField txtAssignName;
	private JTextField txtAssignDate;
	private JTextField txtAssignDue;
	private JTextField txtAssignGrade;
	/**
	 * This class is responsible for creating an assignment, and is responsible for passing information to the main frame to create an object
	 * @param callback creates a callback to the main frame if needed to pass information forward
	 */
	public CreateAssignment(final Callback<ArrayList<String>> callback) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 53, 139, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox cmbSemester = new JComboBox();
		DefaultComboBoxModel dcmSemester = MainApp.getSemesters();
		cmbSemester.setModel(dcmSemester);
		cmbSemester.setBounds(24, 11, 181, 20);
		contentPane.add(cmbSemester);
		
		JComboBox cmbClasses = new JComboBox();
		DefaultComboBoxModel dcmClasses = MainApp.getClasses();
		cmbClasses.setModel(dcmClasses);
		cmbClasses.setBounds(215, 11, 181, 20);
		contentPane.add(cmbClasses);
		
		JLabel lblAssignmentType = new JLabel("Type:");
		lblAssignmentType.setBounds(10, 78, 139, 14);
		contentPane.add(lblAssignmentType);
		
		JLabel lblAssignedDate = new JLabel("Assigned Date: ");
		lblAssignedDate.setBounds(10, 103, 139, 14);
		contentPane.add(lblAssignedDate);
		
		JLabel lblDueDate = new JLabel("Due Date:");
		lblDueDate.setBounds(10, 128, 139, 14);
		contentPane.add(lblDueDate);
		
		JLabel lblGrade = new JLabel("Grade:");
		lblGrade.setBounds(10, 153, 139, 14);
		contentPane.add(lblGrade);
		
		JComboBox cmbAssignType = new JComboBox();
		DefaultComboBoxModel dcmAssignType = new DefaultComboBoxModel();
		dcmAssignType.addElement("HW");
		dcmAssignType.addElement("INCLASS");
		dcmAssignType.addElement("EXAM");
		dcmAssignType.addElement("QUIZ");
		cmbAssignType.setModel(dcmAssignType);
		cmbAssignType.setBounds(118, 75, 181, 20);
		contentPane.add(cmbAssignType);
		
		txtAssignName = new JTextField();
		txtAssignName.setBounds(118, 50, 231, 20);
		contentPane.add(txtAssignName);
		txtAssignName.setColumns(10);
		
		txtAssignDate = new JTextField();
		txtAssignDate.setColumns(10);
		txtAssignDate.setBounds(118, 100, 231, 20);
		contentPane.add(txtAssignDate);
		
		txtAssignDue = new JTextField();
		txtAssignDue.setColumns(10);
		txtAssignDue.setBounds(118, 125, 231, 20);
		contentPane.add(txtAssignDue);
		
		txtAssignGrade = new JTextField();
		txtAssignGrade.setColumns(10);
		txtAssignGrade.setBounds(118, 150, 231, 20);
		contentPane.add(txtAssignGrade);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnSubmit) {
					ArrayList<String> data = new ArrayList<>();
					data.add(txtAssignName.getText());
					data.add(txtAssignDate.getText());
					data.add(txtAssignDue.getText());
					if (Validation.isDouble(txtAssignGrade.getText()))
						data.add(txtAssignGrade.getText());
					else {
						JOptionPane.showMessageDialog(contentPane, "Please enter a valid grade (Integer/Doubles only)");
						return;
					}
					data.add(cmbAssignType.getSelectedItem().toString());
					callback.call(data);
					dispose();
				}
			}
		});
		btnSubmit.setBounds(335, 227, 89, 23);
		contentPane.add(btnSubmit);
		
		
	}
}
