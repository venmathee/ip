/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VENMATHEE
 */
class Book{
    String title;
    String author;
    String price;
    String stock;
    String publisher;

    public Book(String title, String author, String price, String stock, String publisher) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrice() {
        return price;
    }

    public String getStock() {
        return stock;
    }

    public String getPublisher() {
        return publisher;
    }
    
    
}
public class book extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>HamenBookShop</title>");            
            out.println("</head>");
            out.println("<body>");
            HashMap<String,Book> Books=new HashMap<>();
            Book book1=new Book("wings of fire","Abdulkalam","980","2","DEvan");
            Book book2=new Book("thirukural","thiruvalluvar","1331","20","DEvan");
            Books.put("wings of fire",book1);
            Books.put("thirukural",book2);
            
             
            out.println("<h3>Hamen Book Shop " +  "</h3>");
            
            String author=request.getParameter("author");
            
            if(Books.containsKey(request.getParameter("title"))){
                Book object=Books.get(request.getParameter("title"));
                if(object.getAuthor().equals(author)){
                    out.println("<h5>BookName: " + object.getTitle()+ "</h5>");
                    out.println("<h5>Bookauthor: " + object.getAuthor()+ "</h5>");
                    out.println("<h5>BookPrice: " + object.getPrice()+ "</h5>");
                    out.println("<h5>Stock: " + object.getStock()+ "</h5>");
                    out.println("<h5>Publisher: " + object.getPublisher()+ "</h5>");
                }
                else{
                    out.println("<h3>  No such author ... </h3>");
                }
            }
            else{
                out.println("<h3>  No such Book ...</h3>");
            }
            
            
            
            
          
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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