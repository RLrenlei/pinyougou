package entity;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description TODO返回结果封装
 * @Author: Ren
 * @Date:Created in 2018/9/28 14:25
 * @Version 1.0
 */
public class Result implements Serializable {
    private boolean success;
    private String message;
    public Result(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
