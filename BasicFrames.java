import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class BasicFrames implements ActionListener {
	private JFrame inputFrame;
	private JTextField inputText;
	private JButton submit;
	public BasicFrames(String text) {
		inputFrame = new JFrame();
		inputText = new JTextField();
		submit = new JButton("Submit");
		submit.addActionListener(this);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel(text), BorderLayout.WEST);
		panel.add(inputText, BorderLayout.CENTER);
		panel.add(submit, BorderLayout.EAST);
		
		inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		inputFrame.setContentPane(panel);
		inputFrame.pack();
		inputFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			inputText.getText();
			ArrayList<String> arr = new ArrayList<>();
			arr.add(inputText.getText());
			Main.passString(arr);
			inputFrame.dispose();
		}
	}
}
