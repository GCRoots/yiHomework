package com.example.demo.rpcFramework.Test;

import com.example.demo.rpcFramework.IDL.ILogin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Login extends ILogin {
    @Override
    public boolean login(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        System.out.println("***********************************");
        return true;
    }
}
