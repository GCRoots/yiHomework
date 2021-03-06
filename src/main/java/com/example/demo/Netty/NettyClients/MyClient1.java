package com.example.demo.Netty.NettyClients;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.sun.javafx.collections.MappingChange;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MyClient1 {
    public static void main(String[] args) throws Exception {
        new MyClient1("localhost", 8089).run();
    }

    private final String host;
    private final int port;

    public MyClient1(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new MyClientInitializer());
            Channel channel = bootstrap.connect(host, port).sync().channel();


            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String s="{\"aa\":\"cc\"}";
            JSON json=JSON.parseObject(s);
            while (true) {
                String s1=in.readLine();
                if (s1=="a"){
                    channel.writeAndFlush("ansjcndjshrgfkjg");
                }else {
                    channel.writeAndFlush(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }

//    public static void main(String[] args) throws InterruptedException {
//        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();
//
//        try {
//            Bootstrap bootstrap=new Bootstrap();
//            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).
//                    handler(new MyClientInitializer());
//            ChannelFuture channelFuture=bootstrap.connect("127.0.0.1", 8089).sync();
//            channelFuture.channel().closeFuture().sync();
//
//
//        }finally {
//            eventLoopGroup.shutdownGracefully();
//        }
//    }

}
