package com.example.demo.rpcFramework.IDL;

import com.example.demo.rpcFramework.Framework.DoSomethingInit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class DoSomething implements DoSomethingInit {
    @Override
    public String doSomething(Method method, String param) throws InvocationTargetException, IllegalAccessException {
        String[] str=param.split("\\|");

        boolean b= (boolean) method.invoke(this,str[2],str[3]);

        if (b){
            return "TRUE";
        }else{
            return "FALSE";
        }
    }
}
