

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DeleteSemester extends JFrame {

	private JPanel contentPane;

	/**
	 * This class is responsible for deleting a semester
	 * @param callback creates a callback to the main frame if needed to pass information forward
	 * 
	 */
	public DeleteSemester(final Callback<Object> callback) {
		DefaultComboBoxModel dcm = MainApp.getSemesters();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 234, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cmbSemester = new JComboBox();
		cmbSemester.setModel(dcm);
		cmbSemester.setBounds(10, 11, 186, 20);
		contentPane.add(cmbSemester);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {
					Object data = new Object();
					data = cmbSemester.getSelectedItem();
					if (data != null) {
						callback.call(data);
					}
					dispose();
				}
			}
		});
		btnNewButton.setBounds(119, 67, 89, 23);
		contentPane.add(btnNewButton);
	}
}
