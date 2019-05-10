package com.example.demo.rpcFramework.Framework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerFk {
    private int port;
    private ServerSocket serverSocket=null;

    public SocketServerFk(int port) throws IOException {
        this.port = port;
        this.serverSocket =new ServerSocket(port);
    }

    public void start(DoSomethingInit doSomethingInit) throws IOException {
        while (true){
            Socket s = serverSocket.accept();
            DoThread doThread=new DoThread();
            doThread.setSocket(s);
            doThread.setDoSomethingInit(doSomethingInit);
            doThread.start();
        }

    }


}
