package org.seckill.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.entity.Seckill;
import org.seckill.service.SeckillService;
import org.seckill.util.dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();

        logger.info("list={}", list);
    }

    @Test
    public void getById() {
        Seckill seckill = seckillService.getById(1000l);
        logger.info("Seckill={}" + seckill);

    }

    @Test
    public void exportSeckillUrl() {
        Exposer exposer = seckillService.exportSeckillUrl(1000l);
        logger.info("Exposer={}", exposer);
        /**
         * Seckill Id:1000
         * MD5:c9b75e0d2a32ec0deacaa1002221499c
         *  秒杀开启时输出秒杀接口地址
         *  否则输出系统时间和秒杀时间
         */
    }

    @Test
    public void executeSeckill() {
        Result r = seckillService.executeSeckill(1000l, 17398754328l, "c9b75e0d2a32ec0deacaa1002221499c");
        logger.info("Result={}" + r);
    }
}