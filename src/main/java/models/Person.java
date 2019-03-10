package models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable {
	private int id;
	private String name;
	private int CNP;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCNP() {
		return CNP;
	}

	public void setCNP(int cNP) {
		CNP = cNP;
	}

	public Person(int id, String name, int CNP) {
		this.id = id;
		this.name = name;
		this.CNP = CNP;
	}

	// The persons with the same fields will have the same hashcode
	public int hashCode() {
		int hash = 1;
		hash = hash * 17 + id;
		hash = hash * 31 + name.hashCode();
		hash = hash * 13 + CNP;
		return hash;
	}

	// If two persons have the same id, they will be considered the same
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Person))
			return false;
		if (obj == this)
			return true;
		return this.getId() == ((Person) obj).getId();
	}

}
