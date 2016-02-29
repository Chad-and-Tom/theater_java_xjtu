package homework;
// �������� java ��
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/MovieServlet")
// ��չ HttpServlet ��
public class MovieServlet extends HttpServlet {
    ServletConfig config=null;                        //����һ��ServletConfig����
    private String user="";                    //����˽���ַ�����������ʼ��
    private String username="root";                    //��������ݿ��û���
    private String password="root";                    //��������ݿ���������
    private String dbName="mysql";                        //��������ݿ���
    private Connection conn;                        //��ʼ������
    private Statement stmt;
    private String column;
    private String row;
    
    //��ʼ�����ݿ����
    ResultSet rs=null;                            //��ʼ�������
    public void init(ServletConfig config)throws ServletException{
     super.init(config);                            //�̳и����init()����
     this.config=config;                            //��ȡ������Ϣ
     user=config.getInitParameter("driverName");//�������ļ��л�ȡJDBC������
     username=config.getInitParameter("username");    //��ȡ���ݿ��û���
      password=config.getInitParameter("password");    //��ȡ���ݿ���������
      dbName=config.getInitParameter("dbName");    //��ȡҪ���ӵ����ݿ�
        }
    public void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
       
    	column =req.getParameter("column");
        row=req.getParameter("row");
        resp.setContentType("text/html;charset=GBK");    //�����ַ������ʽ
        PrintWriter out=resp.getWriter();                //ʵ������������ҳ�����
          out.println("<html>");                    //ʵ�����ɾ�̬Html
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
                String sql="select user from movie1";
                rs=stmt.executeQuery(sql);
                String cache=row+'_'+column;
                HttpSession session = req.getSession();
                String cur_user=(String) session.getAttribute("username");
                stmt.executeUpdate("INSERT INTO movie1 VALUES ('" + cur_user+"','"+cache+"')");
                  out.println("Servlet�������ݿ�ɹ�");
                  out.println("����ѡ����λ��ף����Ӱ���");
//                  out.println("<table border=1 bordercolorlight=#000000>");
//                  out.println("<tr><td width=40>user</td>");
//                   while(rs.next()){
//                    out.println("<tr><td>"+rs.getString(1)+"</td>");
//                    out.println("<tr>");
//                   }
//                   out.println("</table>");
                   rs.close();
                   stmt.close();
                   conn.close();
              }catch(Exception e){
              e.printStackTrace();
              out.println(e.toString());    
              }
              out.println("</center>");
          out.println("</body>");
          out.println("</html>");
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