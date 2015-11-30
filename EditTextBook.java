import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baseclass.TextBook;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class EditTextBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAuthor;
	private JTextField txtVol;
	private JTextField txtYear;
	private JComboBox cmbSemester;
	private JComboBox cmbClasses;
	private JComboBox cmbText;
	private JLabel lblSemesterSelection;
	private JLabel lblClassSelection;
	private JLabel lblTextbookSelection;

	/**
	 * This class is responsible for editing a textbook
	 * @param callback creates a callback to the main frame if needed to pass information forward
	 * 
	 */
	public EditTextBook(final Callback<Object> callback) {
		DefaultComboBoxModel dcmClasses = MainApp.getClasses();
		DefaultComboBoxModel dcmSemester = MainApp.getSemesters();
		DefaultComboBoxModel dcmTextBooks = MainApp.getTextBooks();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 671, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTextbookName = new JLabel("Textbook Name:");
		lblTextbookName.setBounds(10, 11, 92, 14);
		contentPane.add(lblTextbookName);
		
		JLabel lblTextbookAuthor = new JLabel("Textbook Author:");
		lblTextbookAuthor.setBounds(10, 36, 92, 14);
		contentPane.add(lblTextbookAuthor);
		
		JLabel lblTextbookVolume = new JLabel("Textbook Volume:");
		lblTextbookVolume.setBounds(10, 61, 92, 14);
		contentPane.add(lblTextbookVolume);
		
		JLabel lblTextbookYear = new JLabel("Textbook Year:");
		lblTextbookYear.setBounds(10, 86, 92, 14);
		contentPane.add(lblTextbookYear);
		
		txtName = new JTextField();
		txtName.setBounds(132, 8, 218, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAuthor = new JTextField();
		txtAuthor.setColumns(10);
		txtAuthor.setBounds(132, 33, 218, 20);
		contentPane.add(txtAuthor);
		
		txtVol = new JTextField();
		txtVol.setColumns(10);
		txtVol.setBounds(132, 58, 218, 20);
		contentPane.add(txtVol);
		
		txtYear = new JTextField();
		txtYear.setColumns(10);
		txtYear.setBounds(132, 83, 218, 20);
		contentPane.add(txtYear);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(261, 125, 89, 23);
		contentPane.add(btnSubmit);
		
		cmbSemester = new JComboBox();
		cmbSemester.setBounds(438, 33, 187, 20);
		cmbSemester.setModel(dcmSemester);
		contentPane.add(cmbSemester);
		
		cmbClasses = new JComboBox();
		cmbClasses.setBounds(438, 83, 187, 20);
		cmbClasses.setModel(dcmClasses);
		contentPane.add(cmbClasses);
		
		cmbText = new JComboBox();
		cmbText.setBounds(438, 139, 187, 20);
		cmbText.setModel(dcmTextBooks);
		contentPane.add(cmbText);
		
		lblSemesterSelection = new JLabel("Semester Selection");
		lblSemesterSelection.setBounds(438, 11, 129, 14);
		contentPane.add(lblSemesterSelection);
		
		lblClassSelection = new JLabel("Class Selection");
		lblClassSelection.setBounds(436, 61, 100, 14);
		contentPane.add(lblClassSelection);
		
		lblTextbookSelection = new JLabel("Textbook Selection");
		lblTextbookSelection.setBounds(438, 114, 118, 14);
		contentPane.add(lblTextbookSelection);
		
		if (cmbText.getSelectedItem() instanceof TextBook) {
			TextBook t = (TextBook)cmbText.getSelectedItem();
			txtName.setText(t.getBookName());
			txtAuthor.setText(t.getAuthor());
			txtVol.setText(t.getVolume());
			txtYear.setText(t.getYear());
		}
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbText.getSelectedItem() instanceof TextBook) {
					TextBook t = (TextBook)cmbText.getSelectedItem();
					t.setBookName(txtName.getText());
					t.setAuthor(txtAuthor.getText());
					t.setVolume(txtVol.getText());
					t.setYear(txtYear.getText());
					callback.call("");
					dispose();
				}
			}
		});
		
		cmbText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbText.getSelectedItem() instanceof TextBook) {
					TextBook t = (TextBook)cmbText.getSelectedItem();
					txtName.setText(t.getBookName());
					txtAuthor.setText(t.getAuthor());
					txtVol.setText(t.getVolume());
					txtYear.setText(t.getYear());
				}
			}
		});
	}

}
