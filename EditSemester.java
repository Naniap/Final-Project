import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import baseclass.Semester;

public class EditSemester extends JFrame {

	private JPanel contentPane;
	private JTextField txtYear;

	/**
	 * This class is responsible for editing a semester
	 * @param callback creates a callback to the main frame if needed to pass information forward
	 * 
	 */
	public EditSemester(final Callback<Object> callback) {
		DefaultComboBoxModel dcmSemester = MainApp.getSemesters();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cmbSeason = new JComboBox(new String[] { "", "Spring", "Summer", "Fall", "Winter" } );
		cmbSeason.setBounds(81, 51, 127, 20);
		contentPane.add(cmbSeason);
		
		JComboBox cmbSemesters = new JComboBox();
		cmbSemesters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbSemesters.getSelectedItem() instanceof Semester)
				{
					Semester s = (Semester)cmbSemesters.getSelectedItem();
					txtYear.setText(Integer.toString(s.getYear()));
					cmbSeason.setSelectedItem(s.getSeasonName(((Semester)cmbSemesters.getSelectedItem()).getSeason()));
				}
				else
				{
					txtYear.setText("");
					cmbSeason.setSelectedItem("");
				}
			}
		});
		cmbSemesters.setModel(dcmSemester);
		cmbSemesters.setBounds(356, 23, 127, 20);
		contentPane.add(cmbSemesters);
	
		
		JLabel lblSemesterName = new JLabel("Year:");
		lblSemesterName.setBounds(10, 26, 113, 14);
		contentPane.add(lblSemesterName);
		
		txtYear = new JTextField();
		txtYear.setBounds(81, 23, 127, 20);
		contentPane.add(txtYear);
		txtYear.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbSemesters.getSelectedItem() instanceof Semester)
				{
					Semester s = (Semester)cmbSemesters.getSelectedItem();
					s.setSeason(Semester.Season.valueOf(cmbSeason.getSelectedItem().toString().toUpperCase()));
					if (Validation.isInteger(txtYear.getText()))
						s.setYear(Integer.parseInt(txtYear.getText()));
					else {
						JOptionPane.showMessageDialog(contentPane, "Please enter a valid year (integers only)");
						return;
					}
					dispose();
				}
			}
		});
		btnSubmit.setBounds(119, 82, 89, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("Season:");
		lblNewLabel.setBounds(10, 51, 57, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSemesterEditForm = new JLabel("Semester edit form");
		lblSemesterEditForm.setBounds(10, 1, 113, 14);
		contentPane.add(lblSemesterEditForm);
				
		JLabel lblSemesterToEdit = new JLabel("Semester to edit:");
		lblSemesterToEdit.setBounds(245, 26, 103, 14);
		contentPane.add(lblSemesterToEdit);
		
		if (cmbSemesters.getSelectedItem() instanceof Semester)
		{
			Semester s = (Semester)cmbSemesters.getSelectedItem();
			txtYear.setText(Integer.toString(s.getYear()));
			cmbSeason.setSelectedItem(s.getSeasonName(((Semester)cmbSemesters.getSelectedItem()).getSeason()));
		}
		else
		{
			txtYear.setText("");
			cmbSeason.setSelectedItem("");
		}
	}
}
