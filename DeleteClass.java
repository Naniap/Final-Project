

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

public class DeleteClass extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DeleteClass(final Callback<Object> callback) {
		DefaultComboBoxModel dcmClasses = MainApp.getClasses();
		DefaultComboBoxModel dcmSemester = MainApp.getSemesters();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cmbClasses = new JComboBox();
		cmbClasses.setModel(dcmClasses);
		cmbClasses.setBounds(204, 11, 186, 20);
		contentPane.add(cmbClasses);
		
		JComboBox cmbSemester = new JComboBox();
		cmbSemester.setModel(dcmSemester);
		cmbSemester.setBounds(10, 11, 184, 20);
		contentPane.add(cmbSemester);
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {
					Object data = new Object();
					data = cmbClasses.getSelectedItem();
					if (data != null) {
						callback.call(data);
					}
					dispose();
				}
			}
		});
		
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
}
