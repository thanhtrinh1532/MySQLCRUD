package trinh.dev.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Orders {
	public static void readAll(Connection con) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ORDERS";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                Timestamp created_at = rs.getTimestamp("created_at");
                System.out.format("%d:%s:%s:%d:%s", id, code, status, userId, created_at).println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readOne(Connection con) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ORDERS WHERE user_id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 2);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                Timestamp created_at = rs.getTimestamp("created_at");
                System.out.format("%d:%s:%s:%d:%s", id, code, status, userId, created_at).println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void delete(Connection con) {
		// TODO Auto-generated method stub
		 String sql = "DELETE FROM ORDERS WHERE ID = ?";
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
		String sql = "UPDATE ORDERS SET code = ?, status = ?, user_id = ? WHERE id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "order Code");
            stmt.setString(2, "order Status");
            stmt.setInt(3, 1); //1 là id của user
            stmt.setInt(4, 2); //2 là id của order cần cập nhật
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insert(Connection con) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO ORDERS(ID, CODE, STATUS, USER_ID) VALUES(NULL, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "order Code");
            stmt.setString(2, "order Status");
            stmt.setInt(3, 1); //1 là id của user
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
