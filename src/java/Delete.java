import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Delete extends HttpServlet
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
            Class.forName("com.mysql.cj.jdbc.Driver");          
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monday","root","");
            String sql = "DELETE FROM tb WHERE rollno=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, r);
            st.executeUpdate();  
            out.println("<html><head> <style>\n" +
                        "div{\n" +
                        "width: 50%;\n" +
                        "height: 500px;\n" +
                        "border-style: solid;\n" +
                        "border-color: black;\n" +
                        "}\n" +
                        "\n" +
                        "</style></head><body><center><br><div><h1>Recored DELETED....</h1><br><a href='Delete.html'>OK</a></div></center></body></html>");
                
        }
        catch(Exception e)
            {
                e.printStackTrace();
            }  
    }   
}