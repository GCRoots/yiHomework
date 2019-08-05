package com.example.demo.Netty.NettyServers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class JsonServerHandler1 extends SimpleChannelInboundHandler {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        String s=JSON.toJSONString(msg);
        System.out.println(msg);
        System.out.println(s);

        JSONObject jsonObject=JSON.parseObject(msg.toString());
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.toJSONString());
        System.out.println(jsonObject.getString("aa"));
    }
}
