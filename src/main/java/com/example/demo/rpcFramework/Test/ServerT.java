package com.example.demo.rpcFramework.Test;

import com.example.demo.rpcFramework.Framework.SocketServerFk;

import java.io.IOException;

public class ServerT {
    public static void main(String[] args) {
        try {
            SocketServerFk socketServerFks=new SocketServerFk(8888);
            Login login=new Login();
            socketServerFks.start(login);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
