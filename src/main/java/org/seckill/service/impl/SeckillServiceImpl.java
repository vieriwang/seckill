package org.seckill.service.impl;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatkillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.seckill.util.MD5Util;
import org.seckill.util.dto.Result;
import org.seckill.util.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class SeckillServiceImpl implements SeckillService {
    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    public List<Seckill> getSeckillList() {

        return seckillDao.queryAll(0, 4);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    /**
     * 秒杀开启时输出秒杀接口地址
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     */
    public Exposer exportSeckillUrl(long seckillId) {
        Date now = new Date();
        Seckill seckill = seckillDao.queryById(seckillId);
        Exposer exposer;

        if (now.getTime() < seckill.getStartTime().getTime() ||
                now.getTime() > seckill.getEndTime().getTime()) {
            exposer = new Exposer(false, seckillId, now.getTime(), seckill.getStartTime().getTime(), seckill.getEndTime().getTime());

        } else {
            String md5 = MD5Util.getMdStr(seckillId);
            exposer = new Exposer(true, md5, seckillId);

        }
        return exposer;
    }

    /**
     * 执行秒杀操作
     * 秒杀验证用户信息和md5值
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    @Transactional
    public Result executeSeckill(long seckillId, long userPhone, String md5) {
        String realKey = MD5Util.getMdStr(seckillId);
        if (!realKey.equals(md5)) {
            throw new SeckillException(ResultEnum.MD5_VERIFY_ERROR);
        }
        //减库存
        int i = seckillDao.reduceNumber(seckillId, new Date());
        if (i == 0) {
            throw new SeckillCloseException(ResultEnum.SECKILL_CLOSE);
        }
        //插入秒杀成功表
        int j = successKilledDao.insertSuccessKilled(seckillId, userPhone);
        if (j == 0) {
            throw new RepeatkillException(ResultEnum.REPEAT_SECKILL_ERROR);
        }
        return new Result(ResultEnum.SECKILL_SUCCESS);
    }
}
