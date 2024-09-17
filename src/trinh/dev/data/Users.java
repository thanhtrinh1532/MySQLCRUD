package trinh.dev.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {
	public static void readAll(Connection con) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USERS";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				
				String email = rs.getString("email");
				String password = rs.getString("password");
				String role = rs.getString("role");
				
				
				System.out.format("email:%s - password:%s - role:%s",email, password, role).println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readOne(Connection con) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USERS WHERE ID = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 2);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("password");
				String role = rs.getString("role");
				
				
				System.out.format("email:%s - password:%s - role:%s",email, password, role).println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void delete(Connection con) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM USERS WHERE ID = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 1);
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void update(Connection con) {
		// TODO Auto-generated method stub
		String sql = "UPDATE USERS SET email = ? ,password = ?, role = ? WHERE id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "user email");
            stmt.setString(2, "password");
            stmt.setString(3, "role");
            	stmt.setInt(4, 1); //1 la id user can cap nhat			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insert(Connection con) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO USERS(ID, EMAIL, PASSWORD, ROLE) VALUES(null, ?, ?, ?)";		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "user email");
            stmt.setString(2, "password");
            stmt.setString(3, "role");
            
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
