package com.baomidou.samples.druid.mybatis.structrue;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CallResult<T> extends BaseModel {
    private static final long serialVersionUID = -7704551131927143131L;
    public static final int CODE_FAILURE = -1;
    public static final int CODE_SUCCESS = 1;
    private  boolean success;
    private  int code;
    private  String msg;
    private  T resultObject;
    private String stringValue;

    private Integer toPage;
    private Integer total;




    public CallResult(boolean isSuccess, int code, String msg, T resultObject) {
        this.success = isSuccess;
        this.code = code;
        this.msg = msg;
        this.resultObject = resultObject;
    }
    public CallResult(boolean isSuccess, int code, String msg, T resultObject,Integer toPage,Integer total) {
        this.success = isSuccess;
        this.code = code;
        this.msg = msg;
        this.resultObject = resultObject;
        this.toPage = toPage;
        this.total = total;
    }

    public Integer getToPage() {
        return toPage;
    }

    public void setToPage(Integer toPage) {
        this.toPage = toPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public static <T> CallResult<T> success() {
        return new CallResult(true, 1, "default success", null);
    }

    public static <T> CallResult<T> success(T resultObject) {
        return new CallResult(true, 1, "default success", resultObject);
    }

    public static <T> CallResult<T> success(int code, String msg, T resultObject) {
        return new CallResult(true, code, msg, resultObject);
    }
    public static <T> CallResult<T> success(Integer toPage, Integer total, T resultObject) {
        return new CallResult(true, 1, "default success", resultObject,toPage,total);
    }

    public static <T> CallResult<T> failure() {
        return new CallResult(false, -1, "default failure", null);
    }

    public static <T> CallResult<T> failure(String msg) {
        return new CallResult(false, -1, msg, null);
    }

    public static <T> CallResult<T> failure(int code, String msg) {
        return new CallResult(false, code, msg, null);
    }

    @Override
    public String toString() {
        String result = this.stringValue;
        if(result != null) {
            return result;
        } else {
            result = '{' + "\"success\":" + this.success + ',' + "\"code\":" + this.code + ',' + "\"msg\":\"" + this.msg + "\"," + "\"resultObject\":" + this.resultObject + '}';
            this.stringValue = result;
            return result;
        }
    }

    public boolean hasData() {
        return this.resultObject != null;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getResultObject() {
        return this.resultObject;
    }
}
