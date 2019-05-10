package com.example.demo.rpcFramework.IDL;

/**
 * Created by andilyliao on 17-4-9.
 */
public abstract class ILogin extends DoSomething {
    public abstract boolean login(String username,String password);
}
