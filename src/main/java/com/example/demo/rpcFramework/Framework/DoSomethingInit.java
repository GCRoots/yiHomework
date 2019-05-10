package com.example.demo.rpcFramework.Framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface DoSomethingInit {
    String doSomething(Method method,String param) throws InvocationTargetException, IllegalAccessException;
}
