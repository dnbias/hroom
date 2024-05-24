import com.hroom.user.repository.UserRepository;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqReceiver.class);
    @Autowired
    UserRepository repository;

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar
                                         rabbitListenerEndpointRegistrar) { }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(Long userId) {
        LOGGER.info("User Details Received is: " + userId);
        repository.deleteById(userId);
        LOGGER.info("User Deleted: " + userId);
    }
}
