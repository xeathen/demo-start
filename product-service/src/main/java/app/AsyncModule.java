package app;

import app.job.ProductJob;
import app.product.api.kafka.ProductCreatedMessage;
import core.framework.module.Module;

import java.time.Duration;

/**
 * @author Ethan
 */
public class AsyncModule extends Module {
    @Override
    protected void initialize() {
        executor().add();
        schedule().fixedRate("product-job", bind(ProductJob.class), Duration.ofSeconds(5));
        kafka().uri("localhost:9092");
        kafka().poolSize(2);
        kafka().publish("product-created", ProductCreatedMessage.class);
    }
}
