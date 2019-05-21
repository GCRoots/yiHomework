package com.example.demo.seletorProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Selector {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String s="A,B,C,S,Z,Q,Y,P";
        String className = "com.example.demo.seletorProxy.People";
        Class c = Class.forName(className);

        seletor(s,c);

    }

    public static void seletor(String strings,Class c) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String[] s=strings.split(",");
        People people=(People) c.getConstructor().newInstance();

        for (int i=0;i<s.length;i++){
            Method method=c.getDeclaredMethod("set"+s[i].toUpperCase(),boolean.class);
            method.invoke(people,true);
        }

        Method method=c.getDeclaredMethod("toString");
        String ret=(String) method.invoke(people);
        System.out.println(ret);

    }



}
