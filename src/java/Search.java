import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.*;

public class Search extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String r = req.getParameter("rn");         
        try
        { 
            Class.forName("com.mysql.jdbc.Driver");           
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monday","root","");
            String sql = "SELECT * FROM tb WHERE rollno=?";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from tb where rollno="+r+"");  
            if(rs.next()==false)
            {    
                        out.println("<html><head> <style>\n" +
                        "div{\n" +
                        "width: 50%;\n" +
                        "height: 500px;\n" +
                        "border-style: solid;\n" +
                        "border-color: black;\n" +
                        "}\n" +
                        "\n" +
                        "</style></head><body><center><br><div><h1>Recored Not Found....</h1><br><a href='delete.html'>OK</a></div></center></body></html>");            
            } 
             else
            {
                        out.println("<html><head> <style>\n" +
                        "div{\n" +
                        "width: 50%;\n" +
                        "height: 500px;\n" +
                        "border-style: solid;\n" +
                        "border-color: black;\n" +
                        "}\n" +
                        "\n" +
                        "</style></head><body><center><br><div><br><br><table border='1'><tr><td><b>Roll No :</b></td><td>"+rs.getInt(1)+"</td></tr><tr><td><b>Name :</b></td><td>"+rs.getString(2)+"</td></tr><tr><td><b>Gender :</b></td><td>"+rs.getString(3)+"</td></tr><tr><td><b>Department :</b></td><td>"+rs.getString(4)+"</td></tr><tr><td><b>Skill :</b></td><td>"+rs.getString(5)+"</td></tr><tr><td><b>Age :</b></td><td>"+rs.getInt(6)+"</td></tr><tr><td><b>Address :</b></td><td>"+rs.getString(7)+"</td></tr><tr><td><b>Phone No :</b></td><td>"+rs.getString(8)+"</td></tr></table><br><a href='Search.html'>OK</a></div></center></body></html>");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }     
    }
}  

