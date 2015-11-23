

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DeleteTextBook extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DeleteTextBook(final Callback<Object> callback) {
		DefaultComboBoxModel dcmClasses = MainApp.getClasses();
		DefaultComboBoxModel dcmSemester = MainApp.getSemesters();
		DefaultComboBoxModel dcmTextBook = MainApp.getTextBooks();	
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 307, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cmbClasses = new JComboBox();
		cmbClasses.setModel(dcmClasses);
		cmbClasses.setBounds(98, 52, 186, 20);
		contentPane.add(cmbClasses);
		
		JComboBox cmbSemester = new JComboBox();
		cmbSemester.setModel(dcmSemester);
		cmbSemester.setBounds(98, 21, 186, 20);
		contentPane.add(cmbSemester);
		
		JComboBox cmbTxtBook = new JComboBox();
		cmbTxtBook.setModel(dcmTextBook);
		cmbTxtBook.setBounds(98, 83, 186, 20);
		contentPane.add(cmbTxtBook);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {
					Object data = new Object();
					data = cmbTxtBook.getSelectedItem();
					if (data != null) {
						callback.call(data);
					}
					dispose();
				}
			}
		});
		
		
		btnNewButton.setBounds(195, 136, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setBounds(10, 24, 70, 14);
		contentPane.add(lblSemester);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setBounds(10, 55, 70, 14);
		contentPane.add(lblClass);
		
		JLabel lblAssignment = new JLabel("Textbook:");
		lblAssignment.setBounds(8, 86, 70, 14);
		contentPane.add(lblAssignment);
	}
}
