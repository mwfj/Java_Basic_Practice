/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2015-06-26 07:58:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/included/uploadify_lib.jsp", Long.valueOf(1435304321961L));
    _jspx_dependants.put("/included/path_lib.jsp", Long.valueOf(1435300511624L));
    _jspx_dependants.put("/included/jquery_lib.jsp", Long.valueOf(1435300817899L));
    _jspx_dependants.put("/included/jquery_ui_lib.jsp", Long.valueOf(1435300841841L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");

    	String path = request.getContextPath();
    	pageContext.setAttribute("path", path);
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Login</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<script type=\"text/javascript\" \r\n");
      out.write("src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery/jquery.js\"></script>");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<link rel=\"stylesheet\" \r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery_ui/jquery-ui.min.css\">  \r\n");
      out.write("\t\r\n");
      out.write("<link rel=\"stylesheet\" \r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery_ui/jquery-ui.structure.min.css\">  \r\n");
      out.write("\t\r\n");
      out.write("<link rel=\"stylesheet\" \r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery_ui/jquery-ui.theme.min.css\">  \r\n");
      out.write("\t\r\n");
      out.write("<script type=\"text/javascript\" \r\n");
      out.write("src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery_ui/jquery-ui.min.js\"></script>");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" \r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/uploadify/uploadify.css\">  \r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" \r\n");
      out.write("src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/uploadify/jquery.uploadify.min.js\"></script>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$(\"input[type=button], button, a\")\r\n");
      out.write("\t\t\t.button();\r\n");
      out.write("\t\r\n");
      out.write("\t\t$(\"#btnLogin\").click(function(){\r\n");
      out.write("\t\t\t\t$(\"#dialog\").dialog(\"open\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#txtDate\").datepicker();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#file_upload_1\").uploadify({\r\n");
      out.write("\t        height        : 30,\r\n");
      out.write("\t        swf           : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/uploadify/uploadify.swf',\r\n");
      out.write("\t        uploader      : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/upload.action',\r\n");
      out.write("\t        width         : 120,\r\n");
      out.write("\t        fileObjName : \"fileUpload\",\r\n");
      out.write("\t        auto\t: false\r\n");
      out.write("\t    });\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#btnUpload\").on(\"click\", function(){\r\n");
      out.write("\t\t\tif(confirm(\"你确定要上传吗？\")){\r\n");
      out.write("\t\t\t\t$(\"#file_upload_1\").uploadify(\"upload\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar _dialog = $(\"#dialog\").dialog({\r\n");
      out.write("\t\t\tautoOpen: false,\r\n");
      out.write("\t\t\theight: 230,\r\n");
      out.write("\t\t    width: 400,\r\n");
      out.write("\t\t\tshow: {\r\n");
      out.write("\t\t        effect: \"blind\",\r\n");
      out.write("\t\t        duration: 500\r\n");
      out.write("\t\t      },\r\n");
      out.write("\t\t      hide: {\r\n");
      out.write("\t\t        effect: \"explode\",\r\n");
      out.write("\t\t        duration: 500\r\n");
      out.write("\t\t      },\r\n");
      out.write("\t\t    buttons: {\r\n");
      out.write("\t\t    \t\"登录\" : login,\r\n");
      out.write("\t\t    \t\"关闭\" : function(){\r\n");
      out.write("\t\t    \t\t_dialog.dialog(\"close\");\r\n");
      out.write("\t\t    \t}\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t      \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction login(){\r\n");
      out.write("\t\t\tvar _loginName = $(\"#txtLoginName\").val();\r\n");
      out.write("\t\t\tvar _loginPassword = $(\"#txtLoginPassword\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.post(\r\n");
      out.write("\t\t\t\t\t\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login.action\",\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\"LoginName\" : _loginName,\r\n");
      out.write("\t\t\t\t\t\t\"LoginPassword\" : _loginPassword\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tfunction(data, status){\r\n");
      out.write("\t\t\t\t\t\tif(status == \"success\") {\r\n");
      out.write("\t\t\t\t\t\t\tif(data == \"true\") {\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"登录成功\");\r\n");
      out.write("\t\t\t\t\t\t\t\t_dialog.dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t\t\t\tsetTimeout(function(){\r\n");
      out.write("\t\t\t\t\t\t\t\t\twindow.location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/index.jsp\";\r\n");
      out.write("\t\t\t\t\t\t\t\t}, 1000);\r\n");
      out.write("\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"登录名或密码错误\");\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<button>普通按钮</button>\r\n");
      out.write("\t<a href=\"#\">超链接</a>\r\n");
      out.write("\t<button id=\"btnLogin\">登录</button>\r\n");
      out.write("\t<input type=\"button\" value=\"普通按钮\">\r\n");
      out.write("\t<a href=\"#\">超链接</a><a href=\"#\">超链接</a><a href=\"#\">超链接</a>\r\n");
      out.write("\t\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t\r\n");
      out.write("\t<input type=\"text\" id=\"txtDate\">\r\n");
      out.write("\t\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t\r\n");
      out.write("\t<input type=\"file\" name=\"fileUpload\" id=\"file_upload_1\" />\r\n");
      out.write("\t\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<button id=\"btnUpload\">上传</button>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"dialog\" title=\"登录\">\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t登录名：\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" id=\"txtLoginName\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t登录密码：\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" id=\"txtLoginPassword\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<!-- <tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<button>登录</button>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<button>重置</button>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr> -->\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t \r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
