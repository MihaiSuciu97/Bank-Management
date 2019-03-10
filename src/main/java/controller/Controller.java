package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import file.File_Link;
import models.Account;
import models.Bank;
import models.Person;
import models.SavingAccount;
import models.SpendingAccount;
import views.AddAccountView;
import views.AddPersonView;
import views.FirstView;

public class Controller {
	private File_Link flink = new File_Link();

	public Controller() {
		FirstView firstView = new FirstView();
		firstView.setVisible(true);
		AddPersonView personView = new AddPersonView();
		AddAccountView accountView = new AddAccountView();
		Bank bank = new Bank();
		bank.setHashmap(flink.FileInput());

		List<Person> personsFirst = new ArrayList<Person>(bank.getHashmap().keySet());
		try {
			AddPersonView.createTable(personsFirst, personView.table);
		} catch (IllegalArgumentException | IllegalAccessException e1) {
			e1.printStackTrace();
		}

		// First two buttons
		firstView.addClientAction(e -> {
			personView.setVisible(true);
			firstView.setVisible(false);
		});

		firstView.addAccountAction(e -> {
			accountView.setVisible(true);
			firstView.setVisible(false);
		});
		// Back buttons
		accountView.BackAccountAction(e -> {
			accountView.setVisible(false);
			firstView.setVisible(true);
		});
		personView.BackPersonAction(e -> {
			personView.setVisible(false);
			firstView.setVisible(true);
		});

		// PERSONS
		personView.InsertPersonAction(e -> {
			// Add
			try {
				int id = Integer.parseInt(personView.idText.getText());
				String name = personView.nameText.getText();
				int cnp = Integer.parseInt(personView.CNPText.getText());
				Person person = new Person(id, name, cnp);
				bank.addPerson(person);

				// Display
				List<Person> persons = new ArrayList<Person>();
				persons = bank.getBankPersons();
				try {
					AddPersonView.createTable(persons, personView.table);
				} catch (IllegalArgumentException | IllegalAccessException e1) {
					e1.printStackTrace();
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(personView, "No information detected");
			}
		});

		personView.EditPersonAction(e -> {
			// Edit
			try {
				int id = Integer.parseInt(personView.idText.getText());
				String name = personView.nameText.getText();
				int cnp = Integer.parseInt(personView.CNPText.getText());
				Person person = new Person(id, name, cnp);
				bank.editPerson(person);

				// Display
				List<Person> persons = new ArrayList<Person>();
				persons = bank.getBankPersons();
				try {
					AddPersonView.createTable(persons, personView.table);
				} catch (IllegalArgumentException | IllegalAccessException e1) {
					e1.printStackTrace();
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(personView, "No information detected");
			}

		});

		personView.DeletePersonAction(e -> {
			// Delete
			int id = Integer.parseInt(personView.idText.getText());
			bank.deletePerson(id);
			// Display
			List<Person> persons = new ArrayList<Person>();
			persons = bank.getBankPersons();
			try {
				AddPersonView.createTable(persons, personView.table);
			} catch (IllegalArgumentException | IllegalAccessException e1) {
				e1.printStackTrace();
			}
			System.out.println("Deleted");
		});

		// ACCOUNTS
		accountView.InsertAccountAction(e -> {
			int id = Integer.parseInt(accountView.idAccountText.getText());
			int sold = Integer.parseInt(accountView.soldText.getText());
			int personid = Integer.parseInt(accountView.personText.getText());

			if (Integer.parseInt(accountView.accTypeText.getText()) == 0) {
				System.out.println("saving account");

				SavingAccount acc = new SavingAccount(id, sold);
				bank.addAccount(acc, personid);
			} else {
				System.out.println("spending account");
				SpendingAccount acc = new SpendingAccount(id, sold);
				bank.addAccount(acc, personid);
			}

			// display
			List<Account> accounts = new ArrayList<Account>();
			accounts = bank.getBankAccounts(personid);
			// System.out.println("acc: " + accounts.get(0).getIdAccount());
			try {
				AddAccountView.createTable(accounts, accountView.table);
			} catch (IllegalArgumentException | IllegalAccessException e1) {
				e1.printStackTrace();
			}

		});

		accountView.DeleteAccountAction(e -> {
			int id = Integer.parseInt(accountView.idAccountText.getText());
			int personid = Integer.parseInt(accountView.personText.getText());
			bank.deleteAccount(id, personid);

			// display
			List<Account> accounts = new ArrayList<Account>();
			accounts = bank.getBankAccounts(personid);
			System.out.println("acc: " + accounts.get(0).getIdAccount());
			try {
				AddAccountView.createTable(accounts, accountView.table);
			} catch (IllegalArgumentException | IllegalAccessException e1) {
				e1.printStackTrace();
			}
		});
		firstView.closeWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				flink.FileOutput(bank.getHashmap());
			}

		});
		// deposit and withdraw
		accountView.DepositAccountAction(e -> {
			int suma = Integer.parseInt(accountView.moneyText.getText());
			int idPerson = Integer.parseInt(accountView.idPersonText.getText());
			int idAccount = Integer.parseInt(accountView.idMoneyText.getText());
			bank.depositMoney(idPerson, idAccount, suma);
			// Display
			List<Account> accounts = new ArrayList<Account>();
			accounts = bank.getBankAccounts(idPerson);
			try {
				AddAccountView.createTable(accounts, accountView.table);
			} catch (IllegalArgumentException | IllegalAccessException e1) {
				e1.printStackTrace();
			}
		});
		accountView.WithdrawAccountAction(e -> {
			int suma = Integer.parseInt(accountView.moneyText.getText());
			int idPerson = Integer.parseInt(accountView.idPersonText.getText());
			int idAccount = Integer.parseInt(accountView.idMoneyText.getText());
			bank.withdrawMoney(idPerson, idAccount, suma);
			// Display
			List<Account> accounts = new ArrayList<Account>();
			accounts = bank.getBankAccounts(idPerson);
			System.out.println("acc: " + accounts.get(0).getIdAccount());
			try {
				AddAccountView.createTable(accounts, accountView.table);
			} catch (IllegalArgumentException | IllegalAccessException e1) {
				e1.printStackTrace();
			}
		});

	}

}
