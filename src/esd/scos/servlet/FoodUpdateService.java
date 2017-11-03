package esd.scos.servlet;

import esd.scos.util.CommonUtils;

import java.io.IOException;
import java.io.PrintWriter;

public class FoodUpdateService extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("welcome");
//        out.flush();
//        out.close();
        response.setContentType("application/json");
        String jsonStr = "{\"name\":\"fly\",\"type\":\"虫子\"}";
        CommonUtils.putJsonToResponse(response, jsonStr);
//        PrintWriter out = response.getWriter();
//        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//        out.println("<HTML>");
//        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//        out.println("  <BODY>");
//        out.print("    This is ");
//        out.print(this.getClass());
//        out.println(", using the POST method");
//        out.println("  </BODY>");
//        out.println("</HTML>");
//        out.flush();
//        out.close();
    }
}
