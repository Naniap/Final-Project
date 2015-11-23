import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Main implements ActionListener {
	private static ArrayList<Semester> semesters = new ArrayList<>();
	private JFrame frame;
	private JButton createSemester;
	
	public Main() {
		frame = new JFrame("Course Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(makePanel());
		//main.setJMenuBar(makeMenuBar());
		frame.pack();
		frame.setVisible(true);
	}
	public JPanel makePanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel(String.format("Semester: %d", 1)), BorderLayout.NORTH);
		createSemester = new JButton();
		createSemester.addActionListener(this);
		
	    panel.add(new JButton("South"), BorderLayout.SOUTH);
	    panel.add(createSemester, BorderLayout.EAST);
	    panel.add(new JButton("West"), BorderLayout.WEST);
	    panel.add(new JButton("Center"), BorderLayout.CENTER);
	    return panel;
	}
	public static void main(String args[]){
		new Main();
	}
	public static void passString(ArrayList<String> s) {
		semesters.add(new Semester(new ArrayList<Class>(), Integer.parseInt(s.get(0)), Semester.Season.FALL));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createSemester) {
			BasicFrames zzz = new BasicFrames("Test");
		}
		else
			System.out.println("nothing");
	}
}
