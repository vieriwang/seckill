package org.seckill.util.enums;

public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    OPER_SUCCESS(0, "成功"),
    OPER_RESPONSE_TRUE(1,"正常返回信息"),
    MD5_VERIFY_ERROR(2,"秒杀验证不通过"),
    REPEAT_SECKILL_ERROR(3,"重复秒杀错误"),
    SECKILL_CLOSE(4,"秒杀结束"),
    SECKILL_SUCCESS(5,"秒杀成功");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}