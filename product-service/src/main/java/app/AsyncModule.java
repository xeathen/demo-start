package app;

import app.kafka.ProductCreatedMessageHandler;
import app.product.api.kafka.ProductCreatedMessage;
import core.framework.module.Module;

/**
 * @author Ethan
 */
public class AsyncModule extends Module {
    @Override
    protected void initialize() {
        executor().add();
//        kafka().uri("localhost:9092");
//        kafka().poolSize(2);
//        kafka().publish("product-created", ProductCreatedMessage.class);
        configureKafka();
    }

    private void configureKafka() {
        kafka().uri("localhost:9092");
        String topic = "product-created";
        kafka().subscribe(topic, ProductCreatedMessage.class, bind(ProductCreatedMessageHandler.class));
        kafka().poolSize(1);
        kafka().publish(topic, ProductCreatedMessage.class);
    }
}
