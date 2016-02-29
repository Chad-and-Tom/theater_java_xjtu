package homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ticket {
	public boolean seats[][]=new boolean[10][10];
	public boolean checkSeat(int r,int c){
		if(seats[r][c]) return true;
		return false;
	}
	public void initalize() throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql=" select * from Person  ";
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			if(rs.getString("ticket")==null) continue;
			if(rs.getString("ticket").equals("yes")){
				seats[rs.getInt("row")][rs.getInt("column")]=true;
			}
		}		
	}
}

