package com.hroom.insertion.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RabbitMQConfig {

    @Bean
    public Queue queue(@Value("${queue.name}") String queueName) {
        return new Queue(queueName, false);
    }
    @Bean
    @ConditionalOnProperty(value = "spring.rabbitmq.template.exchange")
    DirectExchange directExchange(@Value("${spring.rabbitmq.template.exchange}") String exchangeName) {
        return new DirectExchange(exchangeName);
    }
    @Bean
    @ConditionalOnProperty(value = "spring.rabbitmq.template.routing-key")
    Binding directExchangeBinding(@Qualifier("queue") Queue queue,
                                  @Qualifier("directExchange") DirectExchange directExchange,
                                  @Value("${spring.rabbitmq.template.routing-key}") String routingKey) {
        return BindingBuilder.bind(queue).to(directExchange).with(routingKey);
    }

    @Bean
    public Queue queuePhoto(@Value("${queue.photo.name}") String queueName) {
        return new Queue(queueName, false);
    }
    @Bean
    @ConditionalOnProperty(value = "spring.rabbitmq.template.photo.exchange")
    DirectExchange directExchangePhoto(@Value("${spring.rabbitmq.template.photo.exchange}") String exchangeName) {
        return new DirectExchange(exchangeName);
    }
    @Bean
    @ConditionalOnProperty(value = "spring.rabbitmq.template.photo.routing-key")
    Binding directExchangePhotoBinding(@Qualifier("queuePhoto") Queue queuePhoto,
                                       @Qualifier("directExchangePhoto") DirectExchange directExchange,
                                  @Value("${spring.rabbitmq.template.photo.routing-key}") String routingKey) {
        return BindingBuilder.bind(queuePhoto).to(directExchange).with(routingKey);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
