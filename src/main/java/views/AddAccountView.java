package views;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Account;

@SuppressWarnings("serial")
public class AddAccountView extends JFrame {
	private JPanel panel;
	public JTable table;
	private JButton backAccountButton = new JButton("Back");
	private JButton insertAccountButton = new JButton("Insert Account");
	// JButton editAccountButton = new JButton("Edit Account");
	private JButton deletePersonButton = new JButton("Delete Account");
	private JButton depositMoney = new JButton("Deposit money");
	private JButton withdrawMoney = new JButton("Withdraw money");

	public JTextField idAccountText = new JTextField();
	public JTextField soldText = new JTextField("0");
	public JTextField accTypeText = new JTextField();
	public JTextField personText = new JTextField();
	// Deposit and withdraw
	public JTextField moneyText = new JTextField("0");
	public JTextField idMoneyText = new JTextField();
	public JTextField idPersonText = new JTextField();

	public AddAccountView() {

		this.setTitle("Add account");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 900, 500);
		this.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panel);
		panel.setLayout(null);
		panel.setVisible(true);

		// ID
		JLabel idAccountLabel = new JLabel("Id: ");
		idAccountLabel.setBounds(20, 20, 150, 20);
		panel.add(idAccountLabel);
		idAccountText.setBounds(120, 20, 110, 20);
		panel.add(idAccountText);

		// SOLD
		JLabel soldLabel = new JLabel("Sold: ");
		soldLabel.setBounds(20, 50, 150, 20);
		panel.add(soldLabel);
		soldText.setBounds(120, 50, 110, 20);
		panel.add(soldText);

		// PERSON (ID)
		JLabel personidLabel = new JLabel("Person (id): ");
		personidLabel.setBounds(20, 80, 150, 20);
		panel.add(personidLabel);
		personText.setBounds(120, 80, 110, 20);
		panel.add(personText);

		// Account type
		JLabel accTypeLabel = new JLabel("Account Type: ");
		accTypeLabel.setBounds(20, 110, 150, 20);
		panel.add(accTypeLabel);
		accTypeText.setBounds(120, 110, 110, 20);
		panel.add(accTypeText);

		JLabel manageMoneyLabel = new JLabel("Manage money");
		manageMoneyLabel.setBounds(650, 120, 100, 30);
		panel.add(manageMoneyLabel);

		JLabel moneyLabel = new JLabel("Insert money amount ($): ");
		moneyLabel.setBounds(550, 150, 150, 30);
		panel.add(moneyLabel);
		moneyText.setBounds(700, 150, 130, 30);
		panel.add(moneyText);

		JLabel idMoneyLabel = new JLabel("Account id: ");
		idMoneyLabel.setBounds(550, 190, 130, 30);
		panel.add(idMoneyLabel);
		idMoneyText.setBounds(700, 190, 130, 30);
		panel.add(idMoneyText);

		JLabel idPersonLabel = new JLabel("Person id: ");
		idPersonLabel.setBounds(550, 230, 130, 30);
		panel.add(idPersonLabel);
		idPersonText.setBounds(700, 230, 130, 30);
		panel.add(idPersonText);

		// BUTTONS
		insertAccountButton.setBounds(300, 20, 200, 30);
		panel.add(insertAccountButton);
		// editAccountButton.setBounds(300, 60, 200, 30);
		// panel.add(editAccountButton);
		deletePersonButton.setBounds(300, 100, 200, 30);
		panel.add(deletePersonButton);
		backAccountButton.setBounds(750, 20, 70, 30);
		panel.add(backAccountButton);

		depositMoney.setBounds(700, 300, 130, 30);
		panel.add(depositMoney);
		withdrawMoney.setBounds(700, 350, 130, 30);
		panel.add(withdrawMoney);

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(30, 180, 500, 200);
		panel.add(scrollPane);
		JLabel type = new JLabel("(0 for saving and 1 for spending account)");
		type.setBounds(30,125,300,30);
		panel.add(type);
	}

	public void BackAccountAction(ActionListener a) {
		backAccountButton.addActionListener(a);
	}

	public void InsertAccountAction(ActionListener a) {
		insertAccountButton.addActionListener(a);
	}

	public void DeleteAccountAction(ActionListener a) {
		deletePersonButton.addActionListener(a);
	}

	public void DepositAccountAction(ActionListener a) {
		depositMoney.addActionListener(a);
	}

	public void WithdrawAccountAction(ActionListener a) {
		withdrawMoney.addActionListener(a);
	}

	public static void createTable(List<Account> objects, JTable show)
			throws IllegalArgumentException, IllegalAccessException {
		DefaultTableModel tableModel = new DefaultTableModel();
		Object[] data = new Object[10];
		Account object = objects.get(0);

		tableModel.addColumn("Id");
		tableModel.addColumn("sold");

		for (int i = 0; i < objects.size(); i++) {
			object = objects.get(i);
			data[0] = object.getIdAccount();
			data[1] = object.getSold();

			tableModel.addRow(data);
			show.setModel(tableModel);
			show.setVisible(true);
		}
	}
}
