package homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDao {
	private  Person p[]=new Person[80];
	public void add(Person pe) throws SQLException {
		for(int i=0;i<80;i++){
			if(p[i]==null) {p[i]=pe;break;}
		}
		Connection conn=DBUtil.getConnection();
		String sql="insert into Person(username,password,id,name,age,hobby,detail)"+
		"values(?,?,?,?,?,?,?)";
		
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, pe.getUsername());
		ptmt.setString(2, pe.getPassword());
		ptmt.setInt(3, pe.getId());
		ptmt.setString(4, pe.getName());
		ptmt.setString(5, pe.getAge());
		ptmt.setString(6, pe.getHobby());
		ptmt.setString(7, pe.getDetail());
		ptmt.execute();
	}
	public void update(Person pe) throws SQLException {
		Connection conn=DBUtil.getConnection();
		String sql=" update Person set username=?,password=?,id=?,name=?,age=?,hobby=?,detail=? "+
		" where username=? ";
		
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, pe.getUsername());
		ptmt.setString(2, pe.getPassword());
		ptmt.setInt(3, pe.getId());
		ptmt.setString(4, pe.getName());
		ptmt.setString(5, pe.getAge());
		ptmt.setString(6, pe.getHobby());
		ptmt.setString(7, pe.getDetail());
		ptmt.setString(8, pe.getUsername());
		ptmt.execute();
	}
	public void book(String u,int r,int c) throws SQLException{
		this.getPerson(u).book(r, c);
		Person pe=this.getPerson(u);
		Connection conn=DBUtil.getConnection();
		String sql=" update Person set ticket=?,row=?,`column`=? "+
				" where username=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		System.out.println(sql);
			ptmt.setString(1, "yes");
			ptmt.setInt(2, r);
			ptmt.setInt(3, c);
			ptmt.setString(4, u);
			
				ptmt.execute();
	}
	public void cancel(String u) throws SQLException{
		this.getPerson(u).cancel();
		Person pe=this.getPerson(u);
		Connection conn=DBUtil.getConnection();
		String sql=" update Person set ticket=?,row=?,`column`=? "+
				" where username=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		System.out.println(sql);
			ptmt.setString(1, "no");
			ptmt.setInt(2, -1);
			ptmt.setInt(3, -1);
			ptmt.setString(4, u);
			ptmt.execute();
	}
	public int getLength(){
		int i;
		for(i=0;i<80;i++)
			if(p[i]==null) break;
		return i;
	}
	public boolean checkUsername(String u){
		for(int i=0;i<this.getLength();i++)
			if(u.equals(p[i].getUsername())) return false;
		return true;
		
	}
	public boolean checkPassword(String u1,String u2){
		int n;
		for(n=0;n<this.getLength();n++){
			if(u1.equals(p[n].getUsername())) break;
		};
		if(u2.equals(p[n].getPassword())) return true;
		return false;
	}
	public Person getPerson(String u){
		int n;
		for(n=0;n<this.getLength();n++){
			if(u.equals(p[n].getUsername())) break;
		};
		 return p[n];
	}
	public void initalize() throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql=" select * from Person  ";
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		int i=0;
		while(rs.next()){
			this.p[i]=new Person(
					rs.getString("username"),
					rs.getString("password"),
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("age"),
					rs.getString("hobby"),
					rs.getString("detail")
					);
			if(rs.getString("ticket")==null){i++;continue;}
			if(rs.getString("ticket").equals("yes")){
				p[i].book(rs.getInt("row"), rs.getInt("column"));
			}
			i++;
		}
	}
}
