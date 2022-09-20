package com.lty.spring5;

/**
 * @Author: LTY
 * @Date: 2022-09-20-21:05
 * @Description:
 */
public class UserDaoImpl implements UserDao{
    @Override
    public int add(int a, int b) {

        System.out.println("add方法执行");
        return a + b;
    }

    @Override
    public String update(String id) {
        System.out.println("update方法执行");

        return id;
    }
}
