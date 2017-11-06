package esd.scos.servlet;

import com.google.gson.Gson;
import esd.scos.model.Food;
import esd.scos.model.ResultBody;
import esd.scos.util.CommonUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.util.List;

public class FoodUpdateService extends javax.servlet.http.HttpServlet {

    private static final int TYPE_JSON = 1;
    private static final int TYPE_XML = 2;
    private static int Type;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
            response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
            response) throws javax.servlet.ServletException, IOException {

        // 判断发送数据内容
        Type = request.getContentType().equals("applicaiton/json")?TYPE_JSON:TYPE_XML;

        request.setCharacterEncoding("utf-8");

        List<Food> foodList = CommonUtils.getFoodList(1000);

        if (Type == TYPE_JSON) {
            // send json
            String foodListJson = new Gson().toJson(foodList);
            response.setContentType("application/json;charset=utf-8");
            ResultBody resultBody = new ResultBody(1, "请求成功", foodListJson);
            String resultJson = new Gson().toJson(resultBody);
            CommonUtils.putDataToResponse(response, resultJson);
        } else if (Type == TYPE_XML) {
            // send xml
            Element dataString = CommonUtils.parseFoodListToXml(foodList);
            response.setContentType("text/xml; charset=utf-8");
            Document foodDoc = DocumentHelper.createDocument();
            Element result = foodDoc.addElement("Result");
            Element resultCode = result.addElement("RESULTCODE");
            resultCode.addText("1");
            Element message = result.addElement("message");
            message.addText("请求成功");
            result.add(dataString);
            CommonUtils.putDataToResponse(response, foodDoc.asXML());
        }
    }
}
