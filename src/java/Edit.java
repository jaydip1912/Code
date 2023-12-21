import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Edit extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {     
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String r = req.getParameter("rn");
        String nm = req.getParameter("nm");
        String g = req.getParameter("gen");
        String d = req.getParameter("dropdown");
        String s = req.getParameter("c1");
        String a= req.getParameter("ag");
        String ad = req.getParameter("ad");
        String p = req.getParameter("pn");
        
        try
        { 
            Class.forName("com.mysql.cj.jdbc.Driver");          
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monday","root","");
            String sql = "UPDATE tb SET name=?,gender=?,department=?,skill=?,age=?,address=?,no=? where rollno=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, r);
            st.setString(2, nm);
            st.setString(3, g);
            st.setString(4, d);
            st.setString(5,s);
            st.setString(6, a);
            st.setString(7,ad);
            st.setString(8, p);
            st.executeUpdate();  
            out.println("<html><head> <style>\n" +
                        "div{\n" +
                        "width: 50%;\n" +
                        "height: 500px;\n" +
                        "border-style: solid;\n" +
                        "border-color: black;\n" +
                        "}\n" +
                        "\n" +
                        "</style></head><body><center><br><div><h1>Recored Updated....</h1><br><a href='Edit.html'>OK</a></div></center></body></html>");
                
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }  
    }
}
