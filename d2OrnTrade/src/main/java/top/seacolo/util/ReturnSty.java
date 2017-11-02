package top.seacolo.util;

/**
 * 返回数据的封装格式类
 */
public class ReturnSty<T> {
    private String retCode;     //成功失败码
    private String retMessage;  //提示信息
    private T retValue;         //返回值

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    public T getRetValue() {
        return retValue;
    }

    public void setRetValue(T retValue) {
        this.retValue = retValue;
    }

    public ReturnSty() {
    }

    public ReturnSty(String retCode, String retMessage, T retValue) {
        this.retCode = retCode;
        this.retMessage = retMessage;
        this.retValue = retValue;
    }

    public ReturnSty(String retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
}
