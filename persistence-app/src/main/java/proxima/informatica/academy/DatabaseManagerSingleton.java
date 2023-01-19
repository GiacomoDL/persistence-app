package proxima.informatica.academy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import proxima.informatica.academy.dto.RoleDto;
import proxima.informatica.academy.dto.UserDto;

public class DatabaseManagerSingleton {

//	private final static Logger logger = LoggerFactory.getLogger(DatabaseManagerSingleton.class);

	private DatabaseManagerSingleton() {
//		logger.debug("Instanziato Costruttore Privato Database Manager Singleton");
	}

	private static DatabaseManagerSingleton instance;

	public static DatabaseManagerSingleton getInstance() {
		if (instance == null) {
			instance = new DatabaseManagerSingleton();
		}
		return instance;
	}

	public UserDto getUserById(int id) {
		UserDto userToReturn = new UserDto();

		try {
			Connection con = getConnection();

			PreparedStatement query = con.prepareStatement("SELECT * FROM users WHERE id = ?");
			query.setInt(1, id);

			ResultSet rs = query.executeQuery();

			if (rs.next()) {
				userToReturn.setId(rs.getInt(1));
				userToReturn.setEmail(rs.getString(2));
				userToReturn.setPassword(rs.getString(3));
				userToReturn.setFirstname(rs.getString(4));
				userToReturn.setLastname(rs.getString(5));
				userToReturn.setDateofbirth(rs.getDate(6));
				userToReturn.setRegdate(rs.getTimestamp(7));
				userToReturn.setRole(rs.getInt(8));
				userToReturn.setImgpath(rs.getString(9));
				userToReturn.setNote(rs.getString(10));
				userToReturn.setEnabled(rs.getBoolean(11));
			}
			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		return userToReturn;
	}
	
	public RoleDto getRoleById(int id) {
		RoleDto roleToReturn = new RoleDto();

		try {
			Connection con = getConnection();

			PreparedStatement query = con.prepareStatement("SELECT * FROM roles WHERE id = ?");
			query.setInt(1, id);

			ResultSet rs = query.executeQuery();

			if (rs.next()) {
				roleToReturn.setId(rs.getInt(1));
				roleToReturn.setLabel(rs.getString(2));
				roleToReturn.setDescription(rs.getString(3));
				roleToReturn.setLevel(rs.getInt(4));
			}
			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		return roleToReturn;
	}
	
	public UserDto getUserByEmail(String email) {
		UserDto userToReturn = null;
		
		try {
			Connection con = getConnection();
			
			PreparedStatement query = con.prepareStatement("SELECT * FROM users WHERE email = ?");
			query.setString(1, email);
			
			ResultSet rs = query.executeQuery();
			
			if (rs.next()) {
				userToReturn = new UserDto();
				userToReturn.setId(rs.getInt(1));
				userToReturn.setEmail(rs.getString(2));
				userToReturn.setFirstname(rs.getString(3));
				userToReturn.setLastname(rs.getString(4));
			}
			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		return userToReturn;
	}

	public UserDto getUserByEmailAndPassword(String email, String password) {
//		logger.debug("DEBUG - login()");
		UserDto userToReturn = new UserDto();

		try {
			Connection con = getConnection();

			PreparedStatement query = con.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
			query.setString(1, email);
			query.setString(2, password);

			ResultSet rs = query.executeQuery();

			if (rs.next()) {
				userToReturn.setId(rs.getInt(1));
				userToReturn.setEmail(rs.getString(2));
				userToReturn.setPassword(rs.getString(3));
				userToReturn.setFirstname(rs.getString(4));
				userToReturn.setLastname(rs.getString(5));
				userToReturn.setDateofbirth(rs.getDate(6));
				userToReturn.setRegdate(rs.getTimestamp(7));
				userToReturn.setRole(rs.getInt(8));
				userToReturn.setImgpath(rs.getString(9));
				userToReturn.setNote(rs.getString(10));
				userToReturn.setEnabled(rs.getBoolean(11));
			}
			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		return userToReturn;

	}
	
	

	public int insertUser(UserDto user) {
		System.out.println(user.toString());
		Connection con;
		int row = 0;
		try {
			con = getConnection();

			PreparedStatement query = con.prepareStatement(
					"INSERT INTO users (firstname, lastname, email, password, dateofbirth, regdate, role) VALUES(?,?,?,?,?,?,?)");

			query.setString(1, user.getFirstname());
			query.setString(2, user.getLastname());
			query.setString(3, user.getEmail());
			query.setString(4, user.getPassword());
			query.setDate(5, user.getDateofbirth());
			query.setTimestamp(6, user.getRegdate());
			query.setInt(7, 10);

			System.out.println("insert id user " + user.getId());
			row = query.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block

		}
		return row;
	}
	
	public int insertRole(RoleDto role) {
		Connection con;
		int row = 0;
		try {
			con = getConnection();

			PreparedStatement query = con.prepareStatement("INSERT INTO roles (label, description, level) VALUES(?,?,?)");

			query.setString(1, role.getLabel());
			query.setString(2, role.getDescription());
			query.setInt(3, role.getLevel());

			row = query.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block

		}
		return row;
	}

	public ArrayList<UserDto> selectAllUsers() {
		ArrayList<UserDto> listUsers = new ArrayList<UserDto>();

		Connection con;
		try {
			con = getConnection();
			PreparedStatement query = con.prepareStatement("SELECT * FROM users");
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				UserDto user = new UserDto();
				user.setId(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstname(rs.getString(4));
				user.setLastname(rs.getString(5));
				user.setDateofbirth(rs.getDate(6));
				user.setRegdate(rs.getTimestamp(7));
				user.setRole(rs.getInt(8));
				user.setImgpath(rs.getString(9));
				user.setNote(rs.getString(10));
				user.setEnabled(rs.getBoolean(11));
				listUsers.add(user);
			}

			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUsers;
	}
	
	public ArrayList<RoleDto> selectAllRoles() {
		ArrayList<RoleDto> listRoles = new ArrayList<RoleDto>();

		Connection con;
		try {
			con = getConnection();
			PreparedStatement query = con.prepareStatement("SELECT * FROM roles");
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				RoleDto role = new RoleDto();
				role.setId(rs.getInt(1));
				role.setLabel(rs.getString(2));
				role.setDescription(rs.getString(3));
				role.setLevel(rs.getInt(4));

				listRoles.add(role);
			}

			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRoles;
	}

	public int updateUser(UserDto user) {
		System.out.println(user.toString());
		Connection con;
		int row = 0;
		try {
			con = getConnection();
			PreparedStatement query = con.prepareStatement(
					"UPDATE users SET firstname = ?, lastname = ?, email = ?, password = ?, dateofbirth = ?, regdate = ?, role = ?, imgpath = ?, note = ?, enabled = ? WHERE id ="
							+ user.getId());
			System.out.println("Update id " + user.getId());
			query.setString(1, user.getFirstname());
			query.setString(2, user.getLastname());
			query.setString(3, user.getEmail());
			query.setString(4, user.getPassword());
			query.setDate(5, user.getDateofbirth());
			query.setTimestamp(6, user.getRegdate());
			query.setInt(7, user.getRole());
			query.setString(8, user.getImgpath());
			query.setString(9, user.getNote());
			query.setBoolean(10, user.getEnabled());

			row = query.executeUpdate();

			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
	public int updateRole(RoleDto role) {
		Connection con;
		int row = 0;
		try {
			con = getConnection();
			PreparedStatement query = con.prepareStatement(
					"UPDATE roles SET label = ?, description = ?, level = ? WHERE id ="	+ role.getId());
			query.setString(1, role.getLabel());
			query.setString(2, role.getDescription());
			query.setInt(3, role.getLevel());

			row = query.executeUpdate();

			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	public int deleteUser(int id) {
		int row = 0;

		Connection con;
		try {
			con = getConnection();
			PreparedStatement query = con.prepareStatement("DELETE FROM users WHERE id=?");
			query.setInt(1, id);

			row = query.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
	public int deleteRole(int id) {
		int row = 0;

		Connection con;
		try {
			con = getConnection();
			PreparedStatement query = con.prepareStatement("DELETE FROM roles WHERE id=?");
			query.setInt(1, id);

			row = query.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	public int deleteAllUsers() {
		int row = 0;

		Connection con;
		try {
			con = getConnection();
			PreparedStatement query = con.prepareStatement("DELETE FROM users");
			row = query.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(row);
		return row;
	}
	
	public int deleteAllRoles() {
		int row = 0;

		Connection con;
		try {
			con = getConnection();
			PreparedStatement query = con.prepareStatement("DELETE FROM roles");
			row = query.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(row);
		return row;
	}


	private Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

		PropertiesManagerSingleton pms = PropertiesManagerSingleton.getInstance();
		String driver = pms.getProperty("database.mysql.driver");
		Class.forName(driver);
		String host = pms.getProperty("database.mysql.host");
		String port = pms.getProperty("database.mysql.port");
		String dbName = pms.getProperty("database.mysql.db.name");
		String url = "jdbc:mariadb://" + host + ":" + port + "/" + dbName;

		String username = pms.getProperty("database.mysql.db.username");
		String password = pms.getProperty("database.mysql.db.password");

		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}

}
