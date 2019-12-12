package app.customer.demo;

import core.framework.inject.Inject;
import core.framework.log.Markers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ethan
 */
public class Painter {
    private final Logger logger = LoggerFactory.getLogger(Painter.class);
    @Inject
    private Brush brush;

    public void draw() {
        logger.warn(Markers.errorCode("CUSTOMER_ERROR"), "drawing picture...”");
        brush.print();
    }
}
