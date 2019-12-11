package app.kafka;

import app.product.api.kafka.ProductCreatedMessage;
import core.framework.kafka.MessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ethan
 */
public class ProductCreatedMessageHandler implements MessageHandler<ProductCreatedMessage> {
    private final Logger logger = LoggerFactory.getLogger(ProductCreatedMessageHandler.class);

    @Override
    public void handle(String key, ProductCreatedMessage value) throws Exception {
        logger.info("{}-{}", key, value.productId);
    }
}
