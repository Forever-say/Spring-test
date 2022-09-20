package com.lty.spring5;

import com.lty.spring5.aop.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LTY
 * @Date: 2022-09-20-23:18
 * @Description:
 */
public class TestAop {

    @Test
    public void testAopAnno(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);

        user.add();
    }
}
