package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtil {

	private static final String URL="jdbc:mysql://127.0.0.1:3306/theater?useUnicode=true&amp;characterEncoding=utf-8";
	private static final String USER="root";
	private static final String PASSWORD="root";
	
	private static Connection conn=null;
	
	static {
		try {
			//1.������������
			Class.forName("com.mysql.jdbc.Driver");
			//2.������ݿ������
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//�������ݿ�
		
	}
	
	public static Connection getConnection(){
		return conn;
	}
	public static void main(String[] args) throws Exception {
		Statement stmt=conn.createStatement();
		ResultSet rs =stmt.executeQuery("select name,age from Person");
		while(rs.next()){
			System.out.println(rs.getString("name")+","+rs.getString("age"));
		}
	}
}
