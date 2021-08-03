package com.example.mqrabbitmqproducer.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mqrabbitmqproducer.util.rabbitmq.DirectSender;
import com.example.mqrabbitmqproducer.util.rabbitmq.RabbitMQConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟测试消息发送
 * @author qzz
 */
@RestController
@RequestMapping("/order")
public class TestRabbitMQSendMsg {

    /**
     * rabbitMQ消息发送
     */
    @Autowired
    private DirectSender directSender;

    /**
     * 测试取消订单，发送消息
     */
    @GetMapping("/cancel")
    public void cancel(){

        //取消订单逻辑省略

        //取消订单，发送消息
        Map<String, Object> map = new HashMap<>();
        map.put("order_number","4364756867987989");
        map.put("product_id","1");
        directSender.send(RabbitMQConstantUtil.CANCEL_ORDER, JSONObject.toJSONString(map));
    }

    /**
     * 测试自动确认订单，发送消息
     */
    @GetMapping("/confirm")
    public void confirm(){

        //自动确认订单，发送消息
        String order_number="4364756867987989";
        directSender.send(RabbitMQConstantUtil.CONFIRM_ORDER, order_number);
    }
}
