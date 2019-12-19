package app.customer.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ethan
 */
public class Brush {
    private final Logger logger = LoggerFactory.getLogger(Brush.class);

    public void print() {
        logger.info("Hello world");
    }
}
