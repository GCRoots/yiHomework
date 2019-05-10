package com.example.demo.rpcFramework.IDL;

import com.example.demo.rpcFramework.Framework.ClientFk;

import java.io.IOException;

public class Client {
    public boolean login(String ip,int port,String username,String password) throws IOException {
        ClientFk clientFk=new ClientFk(ip,port);
        String res=clientFk.send("com.example.demo.rpcFramework.IDL.ILogin|login|"+username+"|"+password);
        switch (res){
            case "TRUE":
                return true;
            default:
                return false;
        }
    }
}
