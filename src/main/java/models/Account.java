package models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Account implements Serializable {
	private int idAccount;
	private int sold;

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public Account(int idAccount, int sold) {
		this.idAccount = idAccount;
		this.sold = sold;
	}
}
