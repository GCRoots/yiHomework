package com.example.demo.Netty.NettyClients;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MyClientHandler extends SimpleChannelInboundHandler<String> {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("**************************************************************");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(s);

    }
}
