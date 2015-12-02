import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import baseclass.Assignment;
import baseclass.Assignment.AssignmentType;

public class EditWeights extends JFrame {

	private JPanel contentPane;
	private JTextField txtHW;
	private JTextField txtExam;
	private JTextField txtInClass;
	private JTextField txtQuiz;
	/**
	 * Create the frame.
	 */
	public EditWeights(final Callback<Object> callback) {
		DefaultComboBoxModel dcmAssign = MainApp.getAssignments();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 287, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAssignmentType = new JLabel("Assignment Type");
		lblAssignmentType.setBounds(10, 11, 153, 14);
		contentPane.add(lblAssignmentType);
		
		JLabel lblWeight = new JLabel("Homework:");
		lblWeight.setBounds(10, 36, 76, 14);
		contentPane.add(lblWeight);
		
		txtHW = new JTextField();
		txtHW.setBounds(110, 33, 128, 20);
		txtHW.setText(Assignment.weightValues.get(AssignmentType.HW).toString());
		contentPane.add(txtHW);
		txtHW.setColumns(10);
		
		JLabel t = new JLabel("Exam:");
		t.setBounds(10, 61, 76, 14);
		contentPane.add(t);
		
		JLabel lblInclass = new JLabel("In-class:");
		lblInclass.setBounds(10, 86, 76, 14);
		contentPane.add(lblInclass);
		
		JLabel lblQuiz = new JLabel("Quiz:");
		lblQuiz.setBounds(10, 111, 76, 14);
		contentPane.add(lblQuiz);
		
		txtExam = new JTextField();
		txtExam.setColumns(10);
		txtExam.setBounds(110, 58, 128, 20);
		txtExam.setText(Assignment.weightValues.get(AssignmentType.EXAM).toString());
		contentPane.add(txtExam);
		
		txtInClass = new JTextField();
		txtInClass.setColumns(10);
		txtInClass.setBounds(110, 83, 128, 20);
		txtInClass.setText(Assignment.weightValues.get(AssignmentType.INCLASS).toString());
		contentPane.add(txtInClass);
		
		txtQuiz = new JTextField();
		txtQuiz.setColumns(10);
		txtQuiz.setBounds(110, 108, 128, 20);
		txtQuiz.setText(Assignment.weightValues.get(AssignmentType.QUIZ).toString());
		contentPane.add(txtQuiz);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Validation.isDouble(txtQuiz.getText()) && Validation.isDouble(txtInClass.getText()) && Validation.isDouble(txtExam.getText()) && Validation.isDouble(txtHW.getText())) {
					Assignment.weightValues.put(Assignment.AssignmentType.QUIZ, Double.parseDouble(txtQuiz.getText()));
					Assignment.weightValues.put(Assignment.AssignmentType.INCLASS, Double.parseDouble(txtInClass.getText()));
					Assignment.weightValues.put(Assignment.AssignmentType.EXAM, Double.parseDouble(txtExam.getText()));
					Assignment.weightValues.put(Assignment.AssignmentType.HW, Double.parseDouble(txtHW.getText()));
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Please enter a valid weights (integer-only or double only)");
					return;
				}
				callback.call("");
				dispose();
			}
		});
		btnSubmit.setBounds(149, 139, 89, 23);
		contentPane.add(btnSubmit);
	}
}
