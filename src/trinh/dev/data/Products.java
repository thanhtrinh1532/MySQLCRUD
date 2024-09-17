package trinh.dev.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Products {
	public static void readAll(Connection con) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM PRODUCTS";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				
				System.out.format("id:%d - name:%s - description:%s - thumbnail:%s - price:%f - quantity:%d", id, name, description, thumbnail, price, quantity).println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readOne(Connection con) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM PRODUCTS WHERE ID = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 2);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				
				System.out.format("id:%d - name:%s - description:%s - thumbnail:%s - price:%f - quantity:%d", id, name, description, thumbnail, price, quantity).println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void delete(Connection con) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM PRODUCTS WHERE ID = ?";
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
		String sql = "UPDATE PRODUCTS SET name = ?, description = ?, thumbnail = ?, price = ?, quantity = ?, category_id = ? WHERE id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "product Name");
		    stmt.setString(2, "product Description");
		    stmt.setString(3, "product Thumbnail");
		    stmt.setDouble(4, 100);
		    stmt.setInt(5, 10);
		    stmt.setInt(6, 1);
		            stmt.setInt(7,10);
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insert(Connection con) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, THUMBNAIL, PRICE, QUANTITY, CATEGORY_ID) VALUES(NULL, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "product Name");
            stmt.setString(2, "product Description");
            stmt.setString(3, "product Thumbnail");
            stmt.setDouble(4, 100);
            stmt.setInt(5, 10);
            stmt.setInt(6, 1);
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
