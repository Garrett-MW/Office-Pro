package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class openOrders_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Open Orders</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\">\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Teko:wght@300..700&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <style>\n");
      out.write("        \n");
      out.write("        table{\n");
      out.write("            margin: auto;\n");
      out.write("            text-align: center;\n");
      out.write("            border: 4px solid black;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            width: 75%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table, th, td{\n");
      out.write("            border: 2px solid black;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        caption{\n");
      out.write("            font-size: 30px;\n");
      out.write("            font-weight: bolder;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #container{\n");
      out.write("            margin-top: 2%;\n");
      out.write("            margin-bottom: 5%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Office Pro</h1>\n");
      out.write("        <nav>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"products.html\" class=\"button\">Products</a></li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <!-- Placeholder for dropdown or additional nav items -->\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"checkout.html\" class=\"button\">Checkout</a></li>\n");
      out.write("                <li><a href=\"order.html\" class=\"button\">Order</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    \n");
      out.write("        <!-- Search Form -->\n");
      out.write("        <form id=\"search-form\" action=\"search_results.html\" method=\"get\" aria-label=\"Search for office products\">\n");
      out.write("            <input type=\"search\" id=\"search-query\" name=\"query\" placeholder=\"Search products...\"\n");
      out.write("                aria-label=\"Search products\" required>\n");
      out.write("            <button type=\"submit\" class=\"button\">Search</button>\n");
      out.write("        </form>\n");
      out.write("    </header>\n");
      out.write("    \n");
      out.write("    <section class=\"office-supplies\">\n");
      out.write("        <h2>Open Orders</h2>\n");
      out.write("        <img src=\"images/supplies.jpg\" alt=\"Office Supplies\" class=\"supplies-image\">\n");
      out.write("    </section>\n");
      out.write("        <div id=\"container\">\n");
      out.write("           <table>\n");
      out.write("                <caption>Open Orders Table</caption>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Order #</th>\n");
      out.write("                    <th>Customer ID</th>\n");
      out.write("                    <th>Fulfilled</th>\n");
      out.write("                </tr>");

                    try {
                        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                        Connection con = DriverManager
                            .getConnection("jdbc:ucanaccess:///Users/garrett/Desktop/AdvancedProjectSystems/OfficeSupply.mdb");
                        Statement st = con.createStatement();
                        String sql;
                        sql = "SELECT * FROM Order WHERE OrderFulfilled = true";
                        ResultSet rs = st.executeQuery(sql);
           
                        while(rs.next()){
                            
      out.write("<tr>\n");
      out.write("                                <td>");
      out.print(rs.getString(5));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(rs.getString(1));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(rs.getString(4));
      out.write("</td>\n");
      out.write("                            </tr>");

                        }
            
                        con.close();

                        } catch (Exception ex) {
                             System.out.println(ex);
                        }
      out.write("\n");
      out.write("           </table>\n");
      out.write("        </div>\n");
      out.write("        <footer>\n");
      out.write("            <p>&copy; 2024 Office Pro. All rights reserved.</p>\n");
      out.write("        </footer>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
