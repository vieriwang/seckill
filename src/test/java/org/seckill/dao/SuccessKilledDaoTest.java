package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {
    @Resource
    private SuccessKilledDao successKilledDao;
    @Test
    public void insertSuccessKilled() {
        int i=successKilledDao.insertSuccessKilled(1001l,13879548259l);
        System.out.println("i:"+i);
    }

    @Test
    public void queryByIdWithSeckill() {
        SuccessKilled s=  successKilledDao.queryByIdWithSeckill(1001l,13879548259l);
        System.out.println(s);
    }
}