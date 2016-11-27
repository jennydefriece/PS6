package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person_Test {
		
	private static PersonDomainModel person1;
	private static UUID person1UUID = UUID.randomUUID();			
	
	@BeforeClass
	public static void personInstance() throws Exception{
		
		Date person1Birth = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		 person1 = new PersonDomainModel();
		 
		try {
			person1Birth = dateFormat.parse("1994-11-27");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		person1.setPersonID(person1UUID);
		person1.setFirstName("Mingkun");
		person1.setMiddleName("a");
		person1.setLastName("Chen");
		person1.setBirthday(person1Birth);
		person1.setCity("Elkton");
		person1.setStreet("702 Stone Gate Blvd");
		person1.setPostalCode(21921);
		
		
		PersonDAL.addPerson(person1);
	}
	
	public static void tearDownAfterClass() throws Exception {
		PersonDAL.deletePerson(person1.getPersonID());
		
		
		@Test
		public static void getAllPersonsTest() {
			ArrayList<PersonDomainModel> test;
			test.add(person1);
			assertNotNull( test== PersonDAL.getAllPersons());
		}
		
		@Test
		public static void getPersonTest(){
		assert(PersonDAL.getPerson(person1UUID) == person1);
		}
		
		@Test
		public void updatePerson() {
			person1.setFirstName("Jenny");
			person1.setPostal(430201);
			PersonDAL.updatePerson(person1);
			assertTrue(person1.setFirstName() == "Jenny");
			assertTrue(person1.setPostal() == "430201");
		}
		@Test
		public static void deletePersonTest(){
		PersonDAL.deletePerson(person1UUID);
		assert(PersonDAL.getPerson(person1UUID)==null);
		}

	}
		

}
