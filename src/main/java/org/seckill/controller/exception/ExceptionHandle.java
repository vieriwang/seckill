package org.seckill.controller.exception;

import org.seckill.exception.SeckillException;
import org.seckill.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.seckill.util.dto.Result;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof SeckillException) {
            SeckillException secKillException = (SeckillException) e;
            return ResultUtil.error(secKillException.getCode(),secKillException.getMessage());
        }
        logger.error("系统异常 {}" ,e);
        return ResultUtil.defaultError();
    }
}
