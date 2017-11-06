package esd.scos.servlet;

import com.google.gson.Gson;
import esd.scos.model.ResultBody;
import esd.scos.model.LoginParam;
import esd.scos.util.CommonUtils;

import java.io.BufferedReader;
import java.io.IOException;

public class LoginValidator extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
            response) throws javax.servlet.ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        LoginParam loginParam;
        try {
            //读取输入流到StringBuilder中
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                stringBuilder.append(line);

        } catch (Exception e) { /*report an error*/ }

        try {
            Gson gson = new Gson();
            loginParam = gson.fromJson(stringBuilder.toString(), LoginParam.class);
        } catch (Exception e) {
            throw new IOException("Error parsing JSON request string");
        }

        ResultBody resultBody = new ResultBody(0, "登陆失败", null);
        if (loginParam != null && CommonUtils.isNotEmpty(loginParam.getUserName()) && CommonUtils.isNotEmpty
                (loginParam.getPassword())) {
            resultBody.setRESULTCODE(1);
            resultBody.setMsg("登录成功");
        }

        String responseString = new Gson().toJson(resultBody);
        CommonUtils.putDataToResponse(response, responseString);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
            response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
