package com.example.demo.rpcFramework.Test;

import com.example.demo.rpcFramework.IDL.Client;

import java.io.IOException;

public class ClientT {
    public static void main(String[] args) {
        Client client=new Client();
        try {
            boolean res=client.login
                    ("localhost",8888,"aaa","aaa");
            System.out.println(res);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}
