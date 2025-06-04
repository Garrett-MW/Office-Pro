package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class order_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"styles.css\">\n");
      out.write("    <title>Order</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <a href=\"products.jsp\" class=\"logo\">Office Pro</a>\n");
      out.write("        <nav>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"products.jsp\" class=\"button\">Products</a></li>\n");
      out.write("                <li><a href=\"checkout.jsp\" class=\"button\">Checkout</a></li>\n");
      out.write("                <li><a href=\"order.jsp\" class=\"button\">My Orders</a></li>\n");
      out.write("                <li><a href=\"DisplayCustomerInfo.jsp\" class=\"button\">Account</a></li>\n");
      out.write("                <li><a href=\"index.jsp\" class=\"button\">Log Out</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("        <!-- Search Form -->\n");
      out.write("        <form id=\"search-form\" action=\"search_results.html\" method=\"get\">\n");
      out.write("            <input type=\"text\" id=\"search-query\" name=\"query\" placeholder=\"Search products...\">\n");
      out.write("            <button type=\"submit\" id=\"searchBtn\">Search</button>\n");
      out.write("        </form>\n");
      out.write("    </header>\n");
      out.write("    <section class=\"office-supplies\">\n");
      out.write("        <h2>Thank You!</h2>\n");
      out.write("        <img src=\"images/supplies.jpg\" alt=\"Office Supplies\" class=\"supplies-image\">\n");
      out.write("    </section>\n");
      out.write("        <main>\n");
      out.write("            <main>\n");
      out.write("                <section class=\"confirmation\">\n");
      out.write("                    <h2>Thank you for your order!</h2>\n");
      out.write("                    <p>Your order has been successfully placed.</p>\n");
      out.write("        \n");
      out.write("                    <!-- Order Summary -->\n");
      out.write("                    <div class=\"order-summary\">\n");
      out.write("                        <h3>Order Summary</h3>\n");
      out.write("                        <p><strong>Order ID:</strong> 123456789</p>\n");
      out.write("                        <p><strong>Name:</strong> John Doe</p>\n");
      out.write("                        <p><strong>Email:</strong> johndoe@example.com</p>\n");
      out.write("                        <p><strong>Phone:</strong> (123) 456-7890</p>\n");
      out.write("                        <p><strong>Shipping Address:</strong> 123 Main Street, City, County, Zip</p>\n");
      out.write("                        <p><strong>Total Price:</strong> $150.00</p>\n");
      out.write("        \n");
      out.write("                        <h4>Items Ordered:</h4>\n");
      out.write("                        <ul>\n");
      out.write("                            <li>Product 1 - Quantity: 2 - Price: $50.00</li>\n");
      out.write("                            <li>Product 2 - Quantity: 1 - Price: $50.00</li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("        \n");
      out.write("                    <!-- Shipping Information -->\n");
      out.write("                    <div class=\"shipping-info\">\n");
      out.write("                        <h3>Shipping Information</h3>\n");
      out.write("                        <p>Your items will be shipped to the address you provided and should arrive within 5-7 business days.</p>\n");
      out.write("                    </div>\n");
      out.write("        \n");
      out.write("                    <!-- CTA to Continue Shopping -->\n");
      out.write("                    <div class=\"continue-shopping\">\n");
      out.write("                        <a href=\"products.jsp\" class=\"button\">Continue Shopping</a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            \n");
      out.write("        </main>\n");
      out.write("        <footer>\n");
      out.write("            <p>&copy; 2024 Office Pro. All rights reserved.</p>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <script src=\"scripts.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
