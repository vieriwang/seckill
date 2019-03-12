package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.entity.Seckill;
import org.seckill.util.dto.Result;

import java.util.List;

/**
 *  业务接口：站在"使用者"角度设计接口
 *  三个方面：方法定义粒度,参数,返回类型(return 类型/异常)
 *
 */
public interface SeckillService {
    /**
     * 查询所有秒杀记录
     * @return
     *
     */
    List<Seckill>getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址
     * 否则输出系统时间和秒杀时间
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * 秒杀验证用户信息和md5值
     * @param seckillId
     * @param phone
     * @param md5
     */
    Result executeSeckill(long seckillId, long phone, String md5);

}
