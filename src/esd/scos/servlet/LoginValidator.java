package esd.scos.servlet;

import com.google.gson.Gson;
import esd.scos.model.Body;
import esd.scos.model.LoginParam;
import esd.scos.util.CommonUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginValidator extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        StringBuffer jb = new StringBuffer();
        String line = null;
        LoginParam loginParam = null;
        try {
            //读取输入流到StringBuffer中
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);

        } catch (Exception e) { /*report an error*/ }

        try {
            Gson gson = new Gson();
            loginParam = gson.fromJson(jb.toString(), LoginParam.class);
        } catch (Exception e) {
            // crash and burn
            throw new IOException("Error parsing JSON request string");
        }

//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        System.out.println("userName = "+userName);
//        System.out.println("password = "+password);
        Body body = new Body(0, "登陆失败", null);
        if (loginParam != null && CommonUtils.isNotEmpty(loginParam.getUserName()) && CommonUtils.isNotEmpty(loginParam.getPassword())) {
            body.setRESULTCODE(1);
            body.setMsg("登录成功");
            body.setJsonString(jb.toString());
        }

        String responseString = new Gson().toJson(body);
        CommonUtils.putJsonToResponse(response, responseString);
    }
}
