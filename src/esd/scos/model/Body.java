package esd.scos.model;

public class Body {
    // 状态值
    private  int RESULTCODE;

    // 消息
    private  String msg;

    // 携带对象字符串
    private  String jsonString;

    public Body(int RESULTCODE, String msg, String jsonString) {
        this.RESULTCODE = RESULTCODE;
        this.msg = msg;
        this.jsonString = jsonString;
    }

    public int getRESULTCODE() {
        return RESULTCODE;
    }

    public void setRESULTCODE(int RESULTCODE) {
        this.RESULTCODE = RESULTCODE;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }
}
