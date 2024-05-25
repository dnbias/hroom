package com.hroom.admin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RabbitMQConfig {
    //the following beans creates Queues & Exchanges & Bindings programmatically

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
    public Queue queueInsertion(@Value("${queue.insertion.name}") String queueName) {
        return new Queue(queueName, false);
    }
    @Bean
    @ConditionalOnProperty(value = "spring.rabbitmq.template.insertion.exchange")
    DirectExchange directExchangeInsertion(@Value("${spring.rabbitmq.template.insertion.exchange}") String exchangeName) {
        return new DirectExchange(exchangeName);
    }
    @Bean
    @ConditionalOnProperty(value = "spring.rabbitmq.template.insertion.routing-key")
    Binding directExchangeInsertionBinding(@Qualifier("queueInsertion") Queue queueInsertion,
                                           @Qualifier("directExchangeInsertion") DirectExchange directExchange,
                                  @Value("${spring.rabbitmq.template.insertion.routing-key}") String routingKey) {
        return BindingBuilder.bind(queueInsertion).to(directExchange).with(routingKey);
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
    @ConditionalOnProperty(value = "my-topic-exchange")
    TopicExchange topicExchange(@Value("${my-topic-exchange}") String exchangeName) {
        return new TopicExchange(exchangeName);
    }


    @Bean
    @ConditionalOnProperty(value = "my-topic-exchange")
    Binding topicExchangeBinding(Queue queue, TopicExchange topicExchange,
            @Value("${topic-exchange-routing-key}") String routingKey) {
        return BindingBuilder.bind(queue).to(topicExchange).with(routingKey);
    }

}
