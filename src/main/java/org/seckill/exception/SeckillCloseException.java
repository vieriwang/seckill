package org.seckill.exception;

import org.seckill.util.enums.ResultEnum;

/**
 * 秒杀关闭异常
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillCloseException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}