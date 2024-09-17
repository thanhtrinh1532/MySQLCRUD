package trinh.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import trinh.dev.data.Category;

public class MainApp {

	static final String DB_URL = "jdbc:mysql://localhost/shop";
	static final String DB_USER  = "root";
	static final String DB_PASS  = "";
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
				Connection con = getConnection();
				/**
				 * Category
				 */
				Category.insert(con);
				Category.update(con);
				Category.delete(con);
				Category.readOne(con);
				Category.readAll(con);
				
				/**
				 * User
				 */
			}



			public static Connection getConnection() {
				// TODO Auto-generated method stub
				Connection con = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
					System.out.println("Ket noi thanh cong");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return con;
			}

}
