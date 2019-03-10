package models;

import java.util.HashMap;
import java.util.List;

public interface BankProc {
	public void setHashmap(HashMap<Person, List<Account>> hashmap);
	public HashMap<Person, List<Account>> getHashmap();
	public List<Person> getBankPersons();
	public List<Account> getBankAccounts(int id);
	public void addPerson(Person p);
	public void editPerson(Person person);
	public void deletePerson(int aidi);
	public void addAccount(Account account, int id);
	public void deleteAccount(int accid, int personid);
	public void depositMoney(int personId, int accountId, int suma);
	public void withdrawMoney(int personId, int accountId, int suma);
}
