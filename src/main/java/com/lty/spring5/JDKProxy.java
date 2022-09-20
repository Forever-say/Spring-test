package com.lty.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author: LTY
 * @Date: 2022-09-20-21:06
 * @Description:
 */
public class JDKProxy {

    public static void main(String[] args) {
        //创建接口实现类的代理对象

        Class[] interfaces = {UserDao.class};

        UserDao userDao = new UserDaoImpl();
        UserDao dao = (UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));

        int add = dao.add(1, 2);

        System.out.println("result:" + add);
    }
}


//创建代理对象代码

class UserDaoProxy implements InvocationHandler{

    //有参构造传递
    private Object obj;
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前处理
        System.out.println("方法之前执行" + method.getName() + "传递的参数" + Arrays.toString(args));


        //方法执行
        Object res = method.invoke(obj, args);


        //方法之后处理
        System.out.println("方法之后执行" + obj);


        return res;
    }
}
