import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class CreateTextbook extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookName;
	private JTextField txtBookYear;
	private JTextField txtBookVolume;
	private JTextField txtBookAuthor;
	/**
	 * This class is responsible for creating a textbook, and is responsible for passing information to the main frame to create an object
	 * @param callback creates a callback to the main frame if needed to pass information forward
	 * 
	 */
	public CreateTextbook(final Callback<ArrayList<String>> callback) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddBook = new JButton("Submit");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnAddBook) {
					ArrayList<String> data = new ArrayList<String>();
					data.add(txtBookName.getText());
					data.add(txtBookYear.getText());
					data.add(txtBookVolume.getText());
					data.add(txtBookAuthor.getText());
					callback.call(data);
					dispose();
				}
			}
		});
		btnAddBook.setBounds(319, 227, 89, 23);
		contentPane.add(btnAddBook);
		
		JLabel lblNewLabel = new JLabel("Book Name:");
		lblNewLabel.setBounds(10, 53, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(10, 78, 77, 14);
		contentPane.add(lblYear);
		
		JLabel lblNewLabel_1 = new JLabel("Volume:");
		lblNewLabel_1.setBounds(10, 103, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(10, 128, 46, 14);
		contentPane.add(lblAuthor);
		
		txtBookName = new JTextField();
		txtBookName.setBounds(81, 50, 272, 17);
		contentPane.add(txtBookName);
		txtBookName.setColumns(10);
		
		txtBookYear = new JTextField();
		txtBookYear.setColumns(10);
		txtBookYear.setBounds(81, 76, 272, 17);
		contentPane.add(txtBookYear);
		
		txtBookVolume = new JTextField();
		txtBookVolume.setColumns(10);
		txtBookVolume.setBounds(81, 98, 272, 17);
		contentPane.add(txtBookVolume);
		
		txtBookAuthor = new JTextField();
		txtBookAuthor.setColumns(10);
		txtBookAuthor.setBounds(81, 126, 272, 17);
		contentPane.add(txtBookAuthor);
		
		JComboBox cmbSemester = new JComboBox();
		cmbSemester.setBounds(10, 11, 177, 20);
		contentPane.add(cmbSemester);
		DefaultComboBoxModel dcmSem = MainApp.getSemesters();
		cmbSemester.setModel(dcmSem);
		
		JComboBox cmbClass = new JComboBox();
		cmbClass.setBounds(207, 11, 177, 20);
		contentPane.add(cmbClass);
		DefaultComboBoxModel dcmClass = MainApp.getClasses();
		cmbClass.setModel(dcmClass);
	}
}
