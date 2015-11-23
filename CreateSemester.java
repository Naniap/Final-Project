import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateSemester extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateSemester frame = new CreateSemester();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public CreateSemester(final Callback<ArrayList<String>> callback) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 259, 151);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEnterYear = new JLabel("Enter year:");
		GridBagConstraints gbc_lblEnterYear = new GridBagConstraints();
		gbc_lblEnterYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterYear.gridx = 1;
		gbc_lblEnterYear.gridy = 1;
		contentPane.add(lblEnterYear, gbc_lblEnterYear);
		
		JTextArea txtYear = new JTextArea();
		GridBagConstraints gbc_txtYear = new GridBagConstraints();
		gbc_txtYear.insets = new Insets(0, 0, 5, 0);
		gbc_txtYear.fill = GridBagConstraints.BOTH;
		gbc_txtYear.gridx = 4;
		gbc_txtYear.gridy = 1;
		contentPane.add(txtYear, gbc_txtYear);
		
		JLabel lblEnterSeason = new JLabel("Enter season:");
		GridBagConstraints gbc_lblEnterSeason = new GridBagConstraints();
		gbc_lblEnterSeason.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterSeason.gridx = 1;
		gbc_lblEnterSeason.gridy = 2;
		contentPane.add(lblEnterSeason, gbc_lblEnterSeason);
		
		JComboBox cmbSeason = new JComboBox(new String[] { "", "Spring", "Summer", "Fall", "Winter" } );
		GridBagConstraints gbc_cmbSeason = new GridBagConstraints();
		gbc_cmbSeason.insets = new Insets(0, 0, 5, 0);
		gbc_cmbSeason.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSeason.gridx = 4;
		gbc_cmbSeason.gridy = 2;
		contentPane.add(cmbSeason, gbc_cmbSeason);
		
		JButton btnSubmitSemester = new JButton("Submit");
		btnSubmitSemester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnSubmitSemester) {
					ArrayList<String> data = new ArrayList<String>();
					data.add(txtYear.getText());
					data.add(cmbSeason.getSelectedItem().toString());
					callback.call(data);
					dispose();
				}
			}
		});
		GridBagConstraints gbc_btnSubmitSemester = new GridBagConstraints();
		gbc_btnSubmitSemester.insets = new Insets(0, 0, 5, 0);
		gbc_btnSubmitSemester.gridx = 4;
		gbc_btnSubmitSemester.gridy = 3;
		contentPane.add(btnSubmitSemester, gbc_btnSubmitSemester);
	}
}
