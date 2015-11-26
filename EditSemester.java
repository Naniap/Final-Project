import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class EditSemester extends JFrame {

	private JPanel contentPane;
	private JTextField txtYear;

	/**
	 * Create the frame.
	 */
	public EditSemester(final Callback<Object> callback) {
		DefaultComboBoxModel dcmSemester = MainApp.getSemesters();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cmbSemesters = new JComboBox();
		cmbSemesters.setModel(dcmSemester);
		cmbSemesters.setBounds(356, 23, 127, 20);
		contentPane.add(cmbSemesters);
		
		JLabel lblSemesterName = new JLabel("Year:");
		lblSemesterName.setBounds(10, 26, 113, 14);
		contentPane.add(lblSemesterName);
		
		txtYear = new JTextField();
		txtYear.setBounds(81, 23, 127, 20);
		txtYear.setText(Integer.toString(((Semester)cmbSemesters.getSelectedItem()).getYear()));
		contentPane.add(txtYear);
		txtYear.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(119, 82, 89, 23);
		contentPane.add(btnSubmit);
		
		JComboBox cmbSeason = new JComboBox(new String[] { "", "Spring", "Summer", "Fall", "Winter" } );
		cmbSeason.setSelectedItem(((Semester)cmbSemesters.getSelectedItem()).getSeason().toString());
		cmbSeason.setBounds(81, 51, 127, 20);
		contentPane.add(cmbSeason);
		
		JLabel lblNewLabel = new JLabel("Season:");
		lblNewLabel.setBounds(10, 51, 57, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSemesterEditForm = new JLabel("Semester edit form");
		lblSemesterEditForm.setBounds(10, 1, 113, 14);
		contentPane.add(lblSemesterEditForm);
		

		
		JLabel lblSemesterToEdit = new JLabel("Semester to edit:");
		lblSemesterToEdit.setBounds(245, 26, 103, 14);
		contentPane.add(lblSemesterToEdit);
	}
}
