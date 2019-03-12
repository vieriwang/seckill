package org.seckill.exception;

import org.seckill.util.enums.ResultEnum;


/**
 * 秒杀相关业务异常
 */
public class SeckillException extends RuntimeException {
    private Integer code;
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
    public SeckillException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}