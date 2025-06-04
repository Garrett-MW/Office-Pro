package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Business.Employee;

public final class DisplayEmployeeInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Office Supply | Employee Info | Home</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/Style.css\">\n");
      out.write("    ");

        Employee employee = (Employee) session.getAttribute("e1");
        employee.display();
    
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("    <nav class=\"navBar\">\n");
      out.write("        <div>\n");
      out.write("            <ul>\n");
      out.write("                <a href=\"index.jsp\">Home</a>\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/EmployeeUpdate.jsp\">Update Info</a>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("    <div class=\"profile-content\">\n");
      out.write("        <h1>Welcome to Office Supply Depot!</h1>\n");
      out.write("        <!-- Employee info display & update button -->\n");
      out.write("        <div class=\"flex-box-container\">\n");
      out.write("            <div class=\"center\">\n");
      out.write("                <div class=\"flex-box-dentist\">\n");
      out.write("                    <div>ID: ");
      out.print(employee.getId());
      out.write("</div>\n");
      out.write("                    <div>Name: ");
      out.print(employee.getFirstName());
      out.write(' ');
      out.print(employee.getLastName());
      out.write("</div>\n");
      out.write("                    <div>Email: ");
      out.print(employee.getEmail());
      out.write("</div>\n");
      out.write("                    <div>Address: ");
      out.print(employee.getAddr());
      out.write("</div>\n");
      out.write("                    <div>Phone No: ");
      out.print(employee.getPhone());
      out.write("</div>\n");
      out.write("                    <div class=\"spaceBetween\"></div>\n");
      out.write("                    <div>\n");
      out.write("                        <button name=\"goToUpdateBtn\" id=\"goToUpdateBtn\" onclick=\"window.location.href = 'EmployeeUpdate.jsp';\">Update Info</button>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <hr>\n");
      out.write("        <br>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("<footer>\n");
      out.write("</footer>\n");
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
