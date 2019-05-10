package com.example.demo.rpcFramework.Framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class DoThread extends Thread{
    private DoSomethingInit doSomethingInit=null;
    private Socket socket=null;

    public DoSomethingInit getDoSomethingInit() {
        return doSomethingInit;
    }
    public void setDoSomethingInit(DoSomethingInit doSomethingInit) {
        this.doSomethingInit = doSomethingInit;
    }

    public Socket getSocket() {
        return socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            String str[]=line.split("\\|");
            String classname=str[0];
            String methodname=str[1];
            String res="";
            Method[] m = doSomethingInit.getClass().getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
                String name = m[i].getName();
                if (name.equals(methodname)) {
                    res = doSomethingInit.doSomething(m[i], line);
                }
            }
            PrintStream ps = new PrintStream(socket.getOutputStream());
            System.out.println(res);
            ps.println(res);
            ps.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
