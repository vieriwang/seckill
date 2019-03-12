package org.seckill.exception;

import org.seckill.util.enums.ResultEnum;

/**
 * 重复秒杀异常(运行期异常)
 */
public class RepeatkillException extends SeckillException {


    public RepeatkillException(String message) {
        super(message);
    }

    public RepeatkillException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepeatkillException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
