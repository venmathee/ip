import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VENMATHEE
 */
public class mcqexam extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection con;
        Statement st;
        ResultSet rs;
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet mcqexam</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Internet programming Quiz result </h1>");
            
            int mark=0;
            String name = request.getParameter("name");
            String q1 = request.getParameter("a1");
            String q2 = request.getParameter("a2");
            String q3 = request.getParameter("a3");
            String q4 = request.getParameter("a4");
            String q5 = request.getParameter("a5");
            String q6 = request.getParameter("a6");
            String q7 = request.getParameter("a7");
            String q8 = request.getParameter("a8");
            String q9 = request.getParameter("a9");
            String q10 = request.getParameter("a10");
            
            if(q1.equals("True")){
                mark=mark+1;
            }
            
            if(q2.equalsIgnoreCase("James gosling")){
                mark=mark+1;
            }
            
            if(q3.equals("False")){
                mark=mark+1;
            }
            
            if(q4.equals("b2")){
                mark=mark+1;
            }
            
            if(q5.equals("True")){
                mark=mark+1;
            }
            
            if(q6.equals("c1")){
                mark=mark+1;
            }
            
            if(q7.equals("d2")){
                mark=mark+1;
            }
            
            if(q8.equals("e1")&&q8.equals("e3")){
                mark=mark+1;
            }
            
            if(q9.equals("html")){
                mark=mark+1;
            }
            
            if(q10.equalsIgnoreCase("f1")&&q10.equalsIgnoreCase("f3")){
                mark=mark+1;
            }
            
            out.println(name);
            out.println(mark);
            
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ipquiz");
            st =  con.createStatement();
            String insert ="insert into quizresult values('"+name+"',"+mark+")";
            st.executeUpdate(insert);
            out.println("Row inserted...!");
            
            out.println("</body>");
            out.println("</html>");
        } 
        catch(Exception e){
            
        }
        
        
        finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(mcqexam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(mcqexam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}