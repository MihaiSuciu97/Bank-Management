package views;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;
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

@SuppressWarnings("serial")
public class AddPersonView extends JFrame {
	private JPanel panel;
	public JButton insertPersonButton = new JButton("Insert Person");
	public JButton editPersonButton = new JButton("Edit Person");
	public JButton deletePersonButton = new JButton("Delete Person");
	public JButton backPersonButton = new JButton("Back");
	public JTable table;

	public JTextField idText = new JTextField();
	public JTextField nameText = new JTextField();
	public JTextField CNPText = new JTextField();

	public AddPersonView() {

		this.setTitle("Add person");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 750, 400);
		this.setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panel);
		panel.setLayout(null);
		panel.setVisible(true);

		JLabel idLabel = new JLabel("Id: ");
		idLabel.setBounds(20, 20, 100, 20);
		panel.add(idLabel);

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(20, 50, 100, 20);
		panel.add(nameLabel);

		JLabel CNPLabel = new JLabel("CNP: ");
		CNPLabel.setBounds(20, 80, 100, 20);
		panel.add(CNPLabel);

		idText.setBounds(80, 20, 110, 20);
		panel.add(idText);

		nameText.setBounds(80, 50, 110, 20);
		panel.add(nameText);

		CNPText.setBounds(80, 80, 110, 20);
		panel.add(CNPText);

		// BUTTONS
		insertPersonButton.setBounds(220, 10, 200, 30);
		panel.add(insertPersonButton);
		editPersonButton.setBounds(220, 50, 200, 30);
		panel.add(editPersonButton);
		deletePersonButton.setBounds(220, 90, 200, 30);
		panel.add(deletePersonButton);
		backPersonButton.setBounds(630, 20, 70, 30);
		panel.add(backPersonButton);

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(30, 130, 500, 200);
		panel.add(scrollPane);
	}

	public void BackPersonAction(ActionListener a) {
		backPersonButton.addActionListener(a);
	}

	public void InsertPersonAction(ActionListener a) {
		insertPersonButton.addActionListener(a);
	}

	public void EditPersonAction(ActionListener a) {
		editPersonButton.addActionListener(a);
	}

	public void DeletePersonAction(ActionListener a) {
		deletePersonButton.addActionListener(a);
	}

	public static <T> void createTable(List<T> objects, JTable show)
			throws IllegalArgumentException, IllegalAccessException {
		DefaultTableModel tableModel = new DefaultTableModel();
		Object[] data = new Object[10];
		Object object = objects.get(0);
		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			field.getName();
			tableModel.addColumn(field.getName());
		}
		for (int i = 0; i < objects.size(); i++) {
			object = objects.get(i);
			int j = 0;
			for (Field field : object.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Object value = field.get(object);
				data[j] = value;
				j++;
			}
			tableModel.addRow(data);
			show.setModel(tableModel);
			show.setVisible(true);
		}
	}
}
