package com.example.mqrabbitmqconsumer.util.rabbitmq;

/**
 * RabbitMQ RoutingKey 常量工具类
 * @author qzz
 */
public class RabbitMQConstantUtil {

    /**
     * 交换机名称
     */
    public static final String DIRECT_EXCHANGE = "directExchange";

    /**
     * 取消订单 队列名称 \routingkey
     */
    public static final String CANCEL_ORDER = "cancel-order";

    /**
     * 自动确认订单 队列名称\routingkey
     */
    public static final String CONFIRM_ORDER = "confirm-order";


}
