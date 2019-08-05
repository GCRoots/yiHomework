package com.example.demo.SocketPoll;

import java.io.*;
import java.net.Socket;

public class client2 {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            //客户端socket指定服务器的地址和端口号
            socket = new Socket("127.0.0.1", 30001);
            System.out.println("Socket=" + socket);
            //同服务器原理一样
            br = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream())));


            while (true) {
                pw.println("howdy ");
                pw.flush();
                String str = br.readLine();
                System.out.println(str);
                pw.println("END");
                pw.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("close......");
                br.close();
                pw.close();
                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
