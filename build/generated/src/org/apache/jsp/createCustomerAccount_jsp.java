package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createCustomerAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Create Customer Account</title>\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Teko:wght@300..700&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <style>\n");
      out.write("            * {\n");
      out.write("            font-family: \"Teko\", 'san-serif';\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body {\n");
      out.write("            text-align: center;\n");
      out.write("           background-image: url(\"home.jpg\");\n");
      out.write("           background-repeat: repeat-y;\n");
      out.write("           background-size: cover;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            form {\n");
      out.write("            background-color: #E0D8D8;\n");
      out.write("            width: 90%;\n");
      out.write("            margin:auto;\n");
      out.write("            margin-bottom: 5%;\n");
      out.write("            padding: 1%;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            box-shadow: 0px 5px 15px #292F36; /* add shadow to form element*/\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #coName {\n");
      out.write("            font-size: 60px;\n");
      out.write("            color: #A41F13;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #coNameDiv {\n");
      out.write("            width: 60%;\n");
      out.write("            margin: auto;\n");
      out.write("            background-color: #E0D8D8;\n");
      out.write("            box-shadow: 0px 5px 15px #292F36;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            h1 {\n");
      out.write("            font-size: 35px;\n");
      out.write("            color: #292F36;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #headerDiv h1{\n");
      out.write("            font-size: 35px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h3 {\n");
      out.write("            font-size: 20px;\n");
      out.write("            color: #292F36;\n");
      out.write("            margin: 5% 30% 0% 0%;\n");
      out.write("            white-space: nowrap;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #create {\n");
      out.write("            width: 20%;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            margin: auto;\n");
      out.write("            background-color: #92221a;\n");
      out.write("            color: #FAF5F1;\n");
      out.write("            font-size: 20px;\n");
      out.write("            transition: background-color 0.3s ease;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #create:hover {\n");
      out.write("           background-color:#ab554e;\n");
      out.write("           transform: translateY(5px);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #create:active {\n");
      out.write("            background-color: black;\n");
      out.write("            color: white;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input {\n");
      out.write("            width: 60%;\n");
      out.write("            font-size: 15px;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            margin: auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input:focus {\n");
      out.write("            border: 2px solid #A41F13;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #headerDiv {\n");
      out.write("            background-color: #FAF5F1;\n");
      out.write("            width: 60%;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            margin: auto;\n");
      out.write("            text-align: center;\n");
      out.write("            box-shadow: 0px 5px 15px grey;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #mainDiv {\n");
      out.write("            background-color: #FAF5F1;\n");
      out.write("            width: 80%;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            margin: 2% auto;\n");
      out.write("            padding: 7%;\n");
      out.write("            box-shadow: 0px 5px 15px grey;\n");
      out.write("            display: grid;\n");
      out.write("            grid-template-columns: auto;\n");
      out.write("            row-gap: 2%;\n");
      out.write("            column-gap: 2%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            footer p{\n");
      out.write("           background-color: #333;\n");
      out.write("            color: white;\n");
      out.write("            text-align: center;\n");
      out.write("            position: fixed;\n");
      out.write("            width: 100%;\n");
      out.write("            bottom: 0;\n");
      out.write("            margin: auto;\n");
      out.write("            }\n");
      out.write("        \n");
      out.write("\n");
      out.write("        \n");
      out.write("\n");
      out.write("        @media screen and (max-width: 600px){\n");
      out.write("        #coName{\n");
      out.write("            font-size: 50px;\n");
      out.write("        }\n");
      out.write("         #headerDiv h1{\n");
      out.write("            font-size: 30px;\n");
      out.write("         }\n");
      out.write("         h3{\n");
      out.write("            font-size: 20px;\n");
      out.write("         }\n");
      out.write("         input{\n");
      out.write("            height: 20px;\n");
      out.write("         }\n");
      out.write("         #create{\n");
      out.write("            height: 30px;\n");
      out.write("            font-size: 20px;\n");
      out.write("         }\n");
      out.write("         #create:hover{\n");
      out.write("            transform: translateY(2px);\n");
      out.write("         }\n");
      out.write("\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div id=\"coNameDiv\">\n");
      out.write("        <h1 id=\"coName\">Office Pro</h1>\n");
      out.write("    </div>\n");
      out.write("    <form action=\"CreateAccountCustomer\" method=\"post\">\n");
      out.write("        <!-- add servlet to validate information and send to home page signed in-->\n");
      out.write("        <div id=\"headerDiv\">\n");
      out.write("            <h1>Create Account</h1>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"mainDiv\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"custID\">Employee ID:</label>\n");
      out.write("                <input type=\"text\" id=\"custID\" name=\"custID\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"passwd\">Password:</label>\n");
      out.write("                <input type=\"password\" id=\"passwd\" name=\"passwd\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"firstName\">First Name:</label>\n");
      out.write("                <input type=\"text\" id=\"firstName\" name=\"firstName\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"lastName\">Last Name:</label>\n");
      out.write("                <input type=\"text\" id=\"lastName\" name=\"lastName\" required>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"addr\">Address:</label>\n");
      out.write("                <input type=\"text\" id=\"addr\" name=\"addr\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"email\">Email Address:</label>\n");
      out.write("                <input type=\"email\" id=\"email\" name=\"email\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"phone\">Phone Number:</label>\n");
      out.write("                <input type=\"text\" id=\"phone\" name=\"phone\" required>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <input type=\"submit\" name=\"submit\" value=\"Create\" id=\"create\">\n");
      out.write("    </form>\n");
      out.write("    <footer>\n");
      out.write("        <p>&copy; 2024 Office Pro. All rights reserved.</p>\n");
      out.write("    </footer>\n");
      out.write("\n");
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
