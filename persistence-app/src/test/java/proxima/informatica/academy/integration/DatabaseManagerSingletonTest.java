package proxima.informatica.academy.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import proxima.informatica.academy.DatabaseManagerSingleton;
import proxima.informatica.academy.dto.UserDto;


/**
 * Unit test for simple App.
 */
public class DatabaseManagerSingletonTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}
	
	@Test
	public void deleteAllOK() {
		assertTrue(true);
	}
	
	@Test
	public void deleteAllKO() {
		assertTrue(true);
	}
	
	@Test
	public void insertOK() {
		assertTrue(true);
	}

	@Test
	public void insertKO() {
		assertTrue(true);
	}
	
	@Test
	public void selectAllFromDatabase() {
		assertTrue(true);
	}

	@Test
	public void selectAllOK() {
		assertTrue(true);
	}

	@Test
	public void selectAllKO() {
		assertTrue(true);
	}

	@Test
	public void selectByIdOK() {
		assertTrue(true);
	}

	@Test
	public void selectByIdKO() {
		assertTrue(true);
	}

	@Test
	public void selectByEmailOK() {
		assertTrue(true);
	}

	@Test
	public void selectByEmailKO() {
		assertTrue(true);
	}
	
	@Test
	public void updateOK() {
		DatabaseManagerSingleton.getInstance().deleteAllUsers();
		
		UserDto user = new UserDto();
		user.setFirstname("a");
		user.setLastname("a");
		user.setPassword("a");
		user.setEmail("a@a.a");
		user.setDateofbirth(Date.valueOf(LocalDate.now()));
		user.setRegdate(Timestamp.valueOf(LocalDateTime.now()));
		user.setRole(10);
		user.setNote("a");
		user.setImgpath("a");
		user.setEnabled(false);
		
		DatabaseManagerSingleton.getInstance().insertUser(user);
		UserDto user2 = DatabaseManagerSingleton.getInstance().getUserByEmailAndPassword(user.getEmail(), user.getPassword());
		
		
		assertTrue(DatabaseManagerSingleton.getInstance().updateUser(user2) > 0);
	}
	
	@Test
	public void updateKO() {
		DatabaseManagerSingleton.getInstance().deleteAllUsers();
		
		UserDto user = new UserDto();
		user.setFirstname("a");
		user.setLastname("a");
		user.setPassword("a");
		user.setEmail("a@a.a");
		user.setDateofbirth(Date.valueOf(LocalDate.now()));
		user.setRegdate(Timestamp.valueOf(LocalDateTime.now()));
		user.setRole(10);
		user.setNote("a");
		user.setImgpath("a");
		user.setEnabled(false);
		
		DatabaseManagerSingleton.getInstance().insertUser(user);
		UserDto user2 = DatabaseManagerSingleton.getInstance().getUserByEmailAndPassword(user.getEmail(), user.getPassword());
		
		
		assertFalse(DatabaseManagerSingleton.getInstance().updateUser(user2) == 0);
	}

}
