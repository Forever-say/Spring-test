package com.lty.spring5.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author: LTY
 * @Date: 2022-09-20-23:00
 * @Description:
 */


//被增强的类
@Component
public class User {

    public void add(){
        System.out.println("add......");
    }
}
