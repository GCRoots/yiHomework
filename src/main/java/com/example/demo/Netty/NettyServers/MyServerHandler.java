package com.example.demo.Netty.NettyServers;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.UUID;

public class MyServerHandler extends SimpleChannelInboundHandler<String> {


    ChannelGroup channels = Groups.channels;
    private ChannelHandlerContext ctx;
    private String s;

//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        System.out.println(ctx);
//    }


    /**
     * 每当从服务端读到客户端写入信息时，将信息转发给其他客户端的 Channel。
     * 如果你使用的是 Netty 5.x 版本时，需要把 channelRead0() 重命名为messageReceived()
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        this.ctx = ctx;
        this.s = s;
        Channel incoming = ctx.channel();
        System.out.println("ctx.toString():"+ctx.toString());
        System.out.println("ctx.handler():"+ctx.handler());
        System.out.println("ctx.name():"+ctx.name());
        System.out.println("incoming.toString():"+incoming.toString());
        System.out.println("incoming.pipeline():"+incoming.pipeline());
        System.out.println(s);
        System.out.println("[" + incoming.remoteAddress() + "]" + s);

        for (Channel channel : channels) {
            if (channel != incoming) {
                channel.writeAndFlush("[" + incoming.remoteAddress() + "]:" + s);
            } else {
                if (s.equals("quit") || s.equals("exit")) {
                    channel.writeAndFlush("[Server]:您已掉线");
                    ctx.close();
                }
                channel.writeAndFlush("[you]:" + s);
            }
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        // Broadcast a message to multiple Channels
        channels.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " 加入");
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception { // (3)
        Channel incoming = ctx.channel();
        //将消息广播到多个Channel
        channels.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " 离开");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "异常");
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 添加
//        Global.group.add(ctx.channel());
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "在线");
        System.out.println("客户端与服务端连接开启");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // 移除
//        Global.group.remove(ctx.channel());
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "掉线");
        System.out.println("客户端与服务端连接关闭");
    }

}