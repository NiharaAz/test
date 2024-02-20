package com.example.jmeteronly;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Queue;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.GsonMessageConverter;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

import java.util.Map;

@Configuration
public class config {
    public static final String queue_name = "QUE.EXT.PAX.DATA.INGEST.NORM";
    static String SrcPax_id_validate;
    static String Carrier_flightNum_validate;

    public static String getCarrier_flightNum_validate() {
        return Carrier_flightNum_validate;
    }

    public static void setCarrier_flightNum_validate(String carrier_flightNum_validate) {
        Carrier_flightNum_validate = carrier_flightNum_validate;
    }

    public static String getCarrier_cd_validate() {
        return Carrier_cd_validate;
    }

    public static void setCarrier_cd_validate(String carrier_cd_validate) {
        Carrier_cd_validate = carrier_cd_validate;
    }

    static String Carrier_cd_validate;

    public config() {
    }

    public static String getSrcPax_id_validate() {
        return SrcPax_id_validate;
    }

    public static void setSrcPax_id_validate(String srcPax_id_validate) {
        SrcPax_id_validate = srcPax_id_validate;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("icsdevrmq01.devqa.integ.lab");
        System.out.println("host is  {}" + factory.getHost());
        return factory;
    }

    @Bean
    public Queue queue() {
        return new Queue("QUE.EXT.PAX.DATA.INGEST.NORM", true, false, false, Map.of("x-queue-type", "quorum"));
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(this.converter());
        return rabbitTemplate;
    }
}