package esd.scos.util;

import java.io.IOException;
import java.io.PrintWriter;

public class CommonUtils {
    public static void putJsonToResponse(javax.servlet.http.HttpServletResponse response, String jsonValue) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(jsonValue);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static boolean isNotEmpty(String string) {
        return string != null && !string.isEmpty();
    }
}
