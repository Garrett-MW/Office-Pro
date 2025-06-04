package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Checkout</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Office Pro</h1>\n");
      out.write("        <nav>\n");
      out.write("            <ul>\n");
      out.write("                <li> <a href=\"homepage.jsp\" class=\"button\"> Home</a></li>\n");
      out.write("                <li><a href=\"products.jsp\" class=\"button\">Products</a></li>\n");
      out.write("                <li><a href=\"checkout.jsp\" class=\"button\">Checkout</a></li>\n");
      out.write("                <li><a href=\"order.jsp\" class=\"button\">Order</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <!-- Search Form -->\n");
      out.write("        <form id=\"search-form\" action=\"search_results.html\" method=\"get\" aria-label=\"Search for office products\">\n");
      out.write("            <input type=\"search\" id=\"search-query\" name=\"query\" placeholder=\"Search products...\" aria-label=\"Search products\" required>\n");
      out.write("            <button type=\"submit\" class=\"button\">Search</button>\n");
      out.write("        </form>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <section class=\"office-supplies\">\n");
      out.write("        <h2>Cart Summary</h2>\n");
      out.write("        <img src=\"images/supplies.jpg\" alt=\"Office Supplies\" class=\"supplies-image\">\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <main>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"checkoutLayout\">\n");
      out.write("                <div class=\"returnCart\">\n");
      out.write("                    <a href=\"products.jsp\" class=\"button\">Continue Shopping</a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <h1>Cart Summary</h1>\n");
      out.write("\n");
      out.write("                <!-- Clear Cart Button -->\n");
      out.write("                \n");
      out.write("\n");
      out.write("                <div class=\"list\" id=\"cart-items\">\n");
      out.write("                    <div class=\"cart-item\">\n");
      out.write("                        <div class=\"item-name\">Product 1</div>\n");
      out.write("                        <div class=\"item-quantity\">\n");
      out.write("                            <button class=\"quantity-button\" data-action=\"decrease\">-</button>\n");
      out.write("                            <input type=\"number\" class=\"quantity-input\" value=\"1\" min=\"1\" aria-label=\"Quantity\">\n");
      out.write("                            <button class=\"quantity-button\" data-action=\"increase\">+</button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item-price\">$0</div>\n");
      out.write("                        <button class=\"remove-button\" aria-label=\"Remove item\">Remove</button>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Add more cart items as needed -->\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"right\">\n");
      out.write("                    <h1>Checkout</h1>\n");
      out.write("                    <form class=\"form\" aria-label=\"Checkout form\">\n");
      out.write("                        <div class=\"group\">\n");
      out.write("                            <label for=\"full-name\">Full Name</label>\n");
      out.write("                            <input type=\"text\" name=\"full-name\" id=\"full-name\" aria-required=\"true\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"group\">\n");
      out.write("                            <label for=\"phone\">Phone Number</label>\n");
      out.write("                            <input type=\"tel\" name=\"phone\" id=\"phone\" pattern=\"[0-9]{10}\" placeholder=\"1234567890\" aria-required=\"true\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"group\">\n");
      out.write("                            <label for=\"email\">Email</label>\n");
      out.write("                            <input type=\"email\" name=\"email\" id=\"email\" placeholder=\"name@example.com\" aria-required=\"true\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"group\">\n");
      out.write("                            <label for=\"address\">Address</label>\n");
      out.write("                            <input type=\"text\" name=\"address\" id=\"address\" placeholder=\"Street Address\" aria-required=\"true\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"group\">\n");
      out.write("                            <label for=\"county\">County</label>\n");
      out.write("                            <select name=\"county\" id=\"county\" aria-required=\"true\" required>\n");
      out.write("                                <option value=\"\">Select County</option>\n");
      out.write("                                <option value=\"county1\">County 1</option>\n");
      out.write("                                <option value=\"county2\">County 2</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\"  id =\"buttonCheckout\" class=\"buttonCheckout\">Submit</button>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <div class=\"return\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div>Total Quantity</div>\n");
      out.write("                            <div class=\"totalQuantity\">1</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div>Total Price</div>\n");
      out.write("                            <div class=\"totalPrice\">$50</div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("    </main>\n");
      out.write("\n");
      out.write("    <footer>\n");
      out.write("        <p>&copy; 2024 Office Pro. All rights reserved.</p>\n");
      out.write("    </footer>\n");
      out.write("\n");
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
