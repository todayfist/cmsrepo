package com.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mashen.ssm.service.IColumnService;
import com.mashen.ssm.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:applicationContext.xml"})  
public class SpringTest{  
    @Resource
    private IUserService userService;
    @Resource
    private IColumnService columnServiceImp;
    @Test   
    public void testServie2(){  
    	userService.add();
    }
    @Test
    public void testColumnAdd(){
    	columnServiceImp.add();
    }
    @Test
    public void testColumnDelete(){
    	columnServiceImp.delete();
    }
    @Test
    public void testColumnUpdate(){
    	columnServiceImp.update();
    }
}  