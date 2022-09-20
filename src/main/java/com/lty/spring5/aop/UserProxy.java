package com.lty.spring5.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: LTY
 * @Date: 2022-09-20-23:01
 * @Description:
 */
@Component
@Aspect
@Order(1)
public class UserProxy {

//    @Pointcut(value = "execution(* com.qfedu.aop06.service.*.*(..))")
//    public void all(){}

    @Pointcut(value = "execution(* com.lty.spring5.aop.User.add(..))")
    public void UserAdd(){}


    //前置通知
    @Before(value = "UserAdd()")
    public void before(JoinPoint jp){
        System.out.println("before...");
        System.out.println(Arrays.toString(jp.getArgs()) + "   " + jp.getTarget() + "     " + jp.toString());
        System.out.println("this is before");
    }

    //后置通知（返回通知）
    @AfterReturning(value = "UserAdd()")
    public void afterReturning() {
        System.out.println("afterReturning.........");
    }

    //最终通知
    @After(value = "UserAdd()")
    public void after() {
        System.out.println("after.........");
    }

    //异常通知
    @AfterThrowing(value = "UserAdd()")
    public void afterThrowing() {
        System.out.println("afterThrowing.........");
    }

    //环绕通知
    @Around(value = "UserAdd()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.........");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后.........");
    }

}
