package homework;

// 导入必需的 java 库
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Ticket1")
// 扩展 HttpServlet 类
public class Ticket1 extends HttpServlet {
    ServletConfig config=null;                        //定义一个ServletConfig对象
    private String user="";                    //定义私有字符串常量并初始化
    private String username="root";                    //定义的数据库用户名
    private String password="root";                    //定义的数据库连接密码
    private String dbName="mysql";                        //定义的数据库名
    private Connection conn;                        //初始化连接
    private Statement stmt;
    private String column;
    private String row;
    
    //初始化数据库操作
    ResultSet rs=null;                            //初始化结果集
    public void init(ServletConfig config)throws ServletException{
     super.init(config);                            //继承父类的init()方法
     this.config=config;                            //获取配置信息
     user=config.getInitParameter("driverName");//从配置文件中获取JDBC驱动名
     username=config.getInitParameter("username");    //获取数据库用户名
      password=config.getInitParameter("password");    //获取数据库连接密码
      dbName=config.getInitParameter("dbName");    //获取要连接的数据库
        }
    public void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
       
    	column =req.getParameter("column");
        row=req.getParameter("row");
        resp.setContentType("text/html;charset=GBK");    //设置字符编码格式
        PrintWriter out=resp.getWriter();                //实例化对象，用于页面输出
          out.println("<html>");                    //实现生成静态Html
          out.println("<head>");
          out.println("<meta http-equiv=\"Content-Type\"content=\"text/html;charset=GBK\">");
          out.println("<title>DataBase Connection</title>");
          out.println("</head>");
          out.println("<body bgcolor=\"white\">");
          out.println("<center>");
          String url="jdbc:mysql://localhost:3306/mysql";
          try{
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection(url,"root","root");
                stmt=conn.createStatement();
                String sql="select seats from movie1";
                rs=stmt.executeQuery(sql);
                String cache="";
               
                   while(rs.next()){
                   cache=cache+'\''+rs.getString(1)+'\''+',';
                   }
                   rs.close();
                   stmt.close();
                   conn.close();
                   out.println(cache);
                   req.setAttribute("seat", cache);
                   req.getRequestDispatcher("/Page.jsp").forward(req, resp);
                   
                   
              }catch(Exception e){
              e.printStackTrace();
              out.println(e.toString());    
              
              }
           }
           public void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
               this.doGet(req,resp);
               }
               public void destory(){
                   config=null;
                   user=null;
                   username=null;
                   password=null;
                   dbName=null;
                   conn=null;
                   stmt=null;
                   rs=null;
                   }
}