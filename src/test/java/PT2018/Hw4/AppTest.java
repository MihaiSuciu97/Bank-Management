package PT2018.Hw4;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import models.Bank;
import models.Person;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		Bank bank = new Bank();
		Person person = new Person(13, "mihai", 1241);
		bank.addPerson(person);
		for (Person i : bank.getBankPersons()) {
			if (i.getId() == 13) {
				assertTrue(person.equals(i));
			}
		}
	}
}
