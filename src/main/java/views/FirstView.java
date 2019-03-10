package views;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FirstView extends JFrame {
	private JPanel panel;
	private JButton buttonClient = new JButton("Persons");
	private JButton buttonAccount = new JButton("Accounts");

	public FirstView() {

		this.setTitle("Mihai's Bank");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 450, 400);
		this.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panel);
		panel.setLayout(null);
		panel.setVisible(true);

		buttonClient.setBounds(150, 100, 150, 50);
		panel.add(buttonClient);
		buttonAccount.setBounds(150, 200, 150, 50);
		panel.add(buttonAccount);
	}

	public void addAccountAction(ActionListener a) {
		buttonAccount.addActionListener(a);
	}
	
	public void addClientAction(ActionListener a) {
		buttonClient.addActionListener(a);
	}
	public void closeWindowListener(WindowListener windowListener) {
		this.addWindowListener(windowListener);
	}
}
