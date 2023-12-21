import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.*;
public class Add extends HttpServlet 
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
        String[] s = req.getParameterValues("c1");
        String a= req.getParameter("ag");
        String ad = req.getParameter("ad");
        String p = req.getParameter("pn");
        String sk="";
        
        for(int i=0;i<s.length;i++)
            {
                sk+=s[i]+" ";
            }                
            try
            { 
                Class.forName("com.mysql.cj.jdbc.Driver");       
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monday","root","");
                out.println("Success");
                String sql = "INSERT INTO tb values(?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, r);
                st.setString(2, nm);
                st.setString(3, g);
                st.setString(4, d);
                st.setString(5,sk);
                st.setString(6, a);
                st.setString(7, ad);
                st.setString(8,p);
                st.executeUpdate();  
                out.println("Recored Inserted....");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
             
    }

}
