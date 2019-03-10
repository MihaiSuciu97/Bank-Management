package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;

import models.Account;
import models.Bank;
import models.Person;

public class File_Link {
	public void FileOutput(HashMap<Person, List<Account>> hashmap) {
		try {
			FileOutputStream fout = new FileOutputStream("D:\\file.txt");
			ObjectOutputStream object = new ObjectOutputStream(fout);
			object.writeObject(hashmap);
			fout.close();
			System.out.println("success...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public HashMap<Person, List<Account>> FileInput() {

		try {
			FileInputStream fin = new FileInputStream("D:\\file.txt");
			ObjectInputStream object = new ObjectInputStream(fin);
			HashMap<Person, List<Account>> hashmap = (HashMap<Person, List<Account>>) object.readObject();
			System.out.println("Read succesful");

			fin.close();
			return hashmap;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
}
