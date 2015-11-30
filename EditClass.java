import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import baseclass.Class;
import baseclass.Semester;
import baseclass.Professor;

public class EditClass extends JFrame {

	private JPanel contentPane;
	private JTextField txtClassName;
	private JTextField txtProfName;
	private JTextField txtProfEmail;
	private JTextField txtProfOffice;
	private JTextField txtProfHours;
	private JTextField txtProfPhone;
	/**
	 * This class is responsible for editing a class
	 * @param callback creates a callback to the main frame if needed to pass information forward
	 * 
	 */
	public EditClass(final Callback<Object> callback) {
		DefaultComboBoxModel dcmSemester = MainApp.getSemesters();
		DefaultComboBoxModel dcmClasses = MainApp.getClasses();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClassName = new JLabel("Class Name:");
		lblClassName.setBounds(10, 11, 87, 14);
		contentPane.add(lblClassName);
		
		JLabel lblEditProfessorInformation = new JLabel("Edit Professor Information");
		lblEditProfessorInformation.setBounds(10, 36, 161, 14);
		contentPane.add(lblEditProfessorInformation);
		
		JLabel lblProfName = new JLabel("Prof Name:");
		lblProfName.setBounds(10, 61, 69, 14);
		contentPane.add(lblProfName);
		
		JLabel lblProfEmail = new JLabel("Prof Email:");
		lblProfEmail.setBounds(10, 86, 69, 14);
		contentPane.add(lblProfEmail);
		
		JLabel lblProfOffice = new JLabel("Prof Office:");
		lblProfOffice.setBounds(10, 111, 79, 14);
		contentPane.add(lblProfOffice);
		
		JLabel lblProfOfficeHours = new JLabel("Prof Office Hours:");
		lblProfOfficeHours.setBounds(10, 136, 104, 14);
		contentPane.add(lblProfOfficeHours);
		
		JLabel lblProfPhoneNumber = new JLabel("Prof Phone Number:");
		lblProfPhoneNumber.setBounds(10, 161, 115, 14);
		contentPane.add(lblProfPhoneNumber);
		
		JButton btnSubmit = new JButton("Submit");

		btnSubmit.setBounds(217, 189, 89, 23);
		contentPane.add(btnSubmit);
		
		txtClassName = new JTextField();
		txtClassName.setBounds(130, 8, 186, 20);
		contentPane.add(txtClassName);
		txtClassName.setColumns(10);
		
		txtProfName = new JTextField();
		txtProfName.setColumns(10);
		txtProfName.setBounds(130, 61, 186, 20);
		contentPane.add(txtProfName);
		
		txtProfEmail = new JTextField();
		txtProfEmail.setColumns(10);
		txtProfEmail.setBounds(130, 83, 186, 20);
		contentPane.add(txtProfEmail);
		
		txtProfOffice = new JTextField();
		txtProfOffice.setColumns(10);
		txtProfOffice.setBounds(130, 108, 186, 20);
		contentPane.add(txtProfOffice);
		
		txtProfHours = new JTextField();
		txtProfHours.setColumns(10);
		txtProfHours.setBounds(130, 133, 186, 20);
		contentPane.add(txtProfHours);
		
		txtProfPhone = new JTextField();
		txtProfPhone.setColumns(10);
		txtProfPhone.setBounds(130, 158, 186, 20);
		contentPane.add(txtProfPhone);
		
		JComboBox cmbClass = new JComboBox();
		cmbClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbClass.getSelectedItem() instanceof Class) {
					Class c = ((Class)cmbClass.getSelectedItem());
					Professor p = c.getProfessor();
					txtClassName.setText(c.getClassName());
					txtProfName.setText(p.getName());
					txtProfEmail.setText(p.getEmail());
					txtProfHours.setText(p.getOfficeHours());
					txtProfPhone.setText(p.getPhoneNumber());
					txtProfOffice.setText(p.getOffice());
				}
			}
		});
		cmbClass.setBounds(329, 83, 145, 20);
		contentPane.add(cmbClass);
		cmbClass.setModel(dcmClasses);
		
		JLabel lblClassSelection = new JLabel("Class Selection");
		lblClassSelection.setBounds(354, 61, 104, 14);
		contentPane.add(lblClassSelection);
		
		JComboBox cmbSemester = new JComboBox();
		cmbSemester.setBounds(329, 33, 145, 20);
		contentPane.add(cmbSemester);
		cmbSemester.setModel(dcmSemester);
		
		JLabel lblSemesterSelection = new JLabel("Semester Selection");
		lblSemesterSelection.setBounds(354, 11, 131, 14);
		contentPane.add(lblSemesterSelection);
		
		if (cmbClass.getSelectedItem() instanceof Class) {
			Class c = (Class)cmbClass.getSelectedItem();
			Professor p = c.getProfessor();
			txtClassName.setText(c.getClassName());
			txtProfName.setText(p.getName());
			txtProfEmail.setText(p.getEmail());
			txtProfHours.setText(p.getOfficeHours());
			txtProfPhone.setText(p.getPhoneNumber());
			txtProfOffice.setText(p.getOffice());
		}
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbClass.getSelectedItem() instanceof Class) {
					Class c = (Class)cmbClass.getSelectedItem();
					Professor p = c.getProfessor();
					c.setClassName(txtClassName.getText());
					p.setName(txtProfName.getText());
					p.setEmail(txtProfEmail.getText());
					p.setOffice(txtProfOffice.getText());
					p.setOfficeHours(txtProfHours.getText());
					p.setPhoneNumber(txtProfPhone.getText());
					callback.call("");
					dispose();
				}
			}
		});
	}
}
