package com.example.demo.SocketPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class PClient {

    public static void main(String[] args)
            throws IOException {
        Socket socket = new Socket("127.0.0.1", 30001);
        System.out.println(socket.getLocalPort());


        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        while (true) {

            PrintStream ps = new PrintStream(socket.getOutputStream());

            // 进行普通IO操作

            ps.flush();
            // 将Socket对应的输入流包装成BufferedReader

            // 进行普通IO操作
            String line = br.readLine();
            System.out.println("来自服务器的数据：" + line);

            ps.close();
            // 关闭输入流、socket
            br.close();
//        socket.close();
        }

    }
}
