package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")
public class Bank implements Serializable, BankProc {
	private HashMap<Person, List<Account>> hashmap;

	public void setHashmap(HashMap<Person, List<Account>> hashmap) {
		this.hashmap = hashmap;
	}

	public Bank() {
		hashmap = new HashMap<Person, List<Account>>();
	}

	public HashMap<Person, List<Account>> getHashmap() {
		return hashmap;
	}

	public List<Person> getBankPersons() {
		List<Person> list = new ArrayList<Person>(hashmap.keySet());
		return list;
	}

	public List<Account> getBankAccounts(int id) {
		Set<Person> persons = hashmap.keySet();
		for (Person i : persons) {
			if (i.getId() == id) {
				List<Account> list = new ArrayList<Account>(hashmap.get(i));
				return list;
			}
		}
		return null;
	}

	// ADD PERSON
	public void addPerson(Person p) {
		hashmap.put(p, new ArrayList<Account>());
	}

	// EDIT PERSON
	public void editPerson(Person person) {
		Set<Person> persons = hashmap.keySet();
		for (Person i : persons)
			if (i.getId() == person.getId()) {
				List<Account> aux = hashmap.get(i);
				hashmap.remove(i);
				hashmap.put(person, aux);
			}
	}

	// DELETE PERSON
	public void deletePerson(int aidi) {
		Set<Person> persons = hashmap.keySet();
		for (Person i : persons)
			if (i.getId() == aidi) {
				hashmap.remove(i);
			}
	}

	// ADD ACCOUNT
	public void addAccount(Account account, int id) {
		Set<Person> persons = hashmap.keySet();
		for (Person i : persons)
			if (i.getId() == id) {
				List<Account> aux = hashmap.get(i);
				aux.add(account);
			}
	}

	// DELETE ACCOUNT
	public void deleteAccount(int accid, int personid) {
		Set<Person> persons = hashmap.keySet();
		for (Person i : persons)
			if (i.getId() == personid) {
				List<Account> accounts = hashmap.get(i);
				for (Account j : accounts) {
					if (j.getIdAccount() == accid) {
						accounts.remove(j);
					}
				}
			}
	}

	// Deposit and withdraw
	public void depositMoney(int personId, int accountId, int suma) {
		Set<Person> persons = hashmap.keySet();
		for (Person i : persons)
			if (i.getId() == personId) {
				List<Account> accounts = hashmap.get(i);
				for (Account j : accounts) {
					if (j.getIdAccount() == accountId) {
						if (j instanceof SavingAccount) {
							int aux = j.getSold();
							j.setSold(aux + suma + 10);
						} else {
							int aux = j.getSold();
							j.setSold(aux + suma);
						}
					}
				}
			}
	}

	public void withdrawMoney(int personId, int accountId, int suma) {
		Set<Person> persons = hashmap.keySet();
		for (Person i : persons)
			if (i.getId() == personId) {
				List<Account> accounts = hashmap.get(i);
				for (Account j : accounts) {
					if (j.getIdAccount() == accountId) {
						if (j instanceof SavingAccount) {
							int aux = j.getSold();
							j.setSold(aux - suma);
						} else {
							int aux = j.getSold();
							j.setSold(aux - suma - 10);
						}
					}
				}
			}
	}
}