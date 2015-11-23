import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateClass extends JFrame {

	private JPanel contentPane;
	private JTextField txtClassName;
	private JTextField txtProfName;
	private JTextField txtProfEmail;
	private JTextField txtProfOffice;
	private JTextField txtProfOfficeHours;
	private JTextField txtProfPhone;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CreateClass(final Callback<ArrayList<String>> callback) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cmbSemester = new JComboBox();
		cmbSemester.setBounds(72, 11, 156, 20);
		contentPane.add(cmbSemester);
		DefaultComboBoxModel dcmSemester = MainApp.getSemesters();
		cmbSemester.setModel(dcmSemester);
		
		JLabel lblNewLabel = new JLabel("Semester");
		lblNewLabel.setBounds(10, 14, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Class Name:");
		lblNewLabel_1.setBounds(10, 58, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		txtClassName = new JTextField();
		txtClassName.setBounds(166, 55, 168, 20);
		contentPane.add(txtClassName);
		txtClassName.setColumns(10);
		
		JLabel lblProfessorInformation = new JLabel("Professor Information");
		lblProfessorInformation.setBounds(10, 83, 156, 14);
		contentPane.add(lblProfessorInformation);
		
		JLabel lblProfessorName = new JLabel("Professor Name:");
		lblProfessorName.setBounds(10, 127, 99, 14);
		contentPane.add(lblProfessorName);
		
		txtProfName = new JTextField();
		txtProfName.setColumns(10);
		txtProfName.setBounds(166, 124, 168, 20);
		contentPane.add(txtProfName);
		
		JLabel lblProfessorEmail = new JLabel("Professor Email:");
		lblProfessorEmail.setBounds(10, 152, 99, 14);
		contentPane.add(lblProfessorEmail);
		
		txtProfEmail = new JTextField();
		txtProfEmail.setColumns(10);
		txtProfEmail.setBounds(166, 149, 168, 20);
		contentPane.add(txtProfEmail);
		
		JLabel lblProfessorOffice = new JLabel("Professor Office:");
		lblProfessorOffice.setBounds(10, 177, 99, 14);
		contentPane.add(lblProfessorOffice);
		
		txtProfOffice = new JTextField();
		txtProfOffice.setColumns(10);
		txtProfOffice.setBounds(166, 174, 168, 20);
		contentPane.add(txtProfOffice);
		
		JLabel lblProfessorOfficeHours = new JLabel("Professor Office Hours:");
		lblProfessorOfficeHours.setBounds(10, 202, 146, 14);
		contentPane.add(lblProfessorOfficeHours);
		
		txtProfOfficeHours = new JTextField();
		txtProfOfficeHours.setColumns(10);
		txtProfOfficeHours.setBounds(166, 199, 168, 20);
		contentPane.add(txtProfOfficeHours);
		
		JLabel lblProfessorPhoneNumber = new JLabel("Professor Phone:");
		lblProfessorPhoneNumber.setBounds(10, 227, 113, 14);
		contentPane.add(lblProfessorPhoneNumber);
		
		txtProfPhone = new JTextField();
		txtProfPhone.setColumns(10);
		txtProfPhone.setBounds(166, 224, 168, 20);
		contentPane.add(txtProfPhone);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnSubmit) {
					ArrayList<String> data = new ArrayList<String>();
					data.add(txtClassName.getText());
					data.add(txtProfName.getText());
					data.add(txtProfEmail.getText());
					data.add(txtProfOffice.getText());
					data.add(txtProfOfficeHours.getText());
					data.add(txtProfPhone.getText());
					callback.call(data);
					dispose();
				}
			}
		});
		btnSubmit.setBounds(245, 269, 89, 23);
		contentPane.add(btnSubmit);
		
		
	}
}
