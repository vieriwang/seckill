package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() {
        int i = seckillDao.reduceNumber(1000l,new Date());
        System.out.println("i:"+i);
    }

    @Test
    public void queryById() {
        Seckill s= seckillDao.queryById(1000l);
        System.out.println("s:"+s);
    }

    @Test
    public void queryAll() {
        List<Seckill> list = seckillDao.queryAll(0,10);
        for(Seckill s:list){
            System.out.println(s);
        }
    }
}
