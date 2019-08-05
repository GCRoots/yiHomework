package com.example.demo.Netty.NettyServers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class JsonServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        JSONObject jsonObject=JSON.parseObject(msg);
        System.out.println(msg);
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.toJSONString());
        System.out.println(jsonObject.getString("aa"));
    }
}
