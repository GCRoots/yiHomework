package com.example.demo.rpcFramework.Framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientFk {
    private String ip;
    private int port;
    private Socket socket=null;

    public ClientFk(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        socket=new Socket(ip,port);
    }

    public String send(String string) throws IOException {
        PrintStream ps = new PrintStream(socket.getOutputStream());
        // 进行普通IO操作
        ps.println(string);
        ps.flush();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        return line;
    }


}
