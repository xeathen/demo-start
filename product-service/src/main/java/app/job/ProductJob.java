package app.job;

import app.product.service.ProductService;
import core.framework.inject.Inject;
import core.framework.scheduler.Job;
import core.framework.scheduler.JobContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ethan
 */
public class ProductJob implements Job {
    private final Logger logger = LoggerFactory.getLogger(ProductJob.class);
    @Inject
    ProductService productService;

    @Override
    public void execute(JobContext context) throws Exception {
//        logger.debug(ZonedDateTime.now().toString());
        productService.publish();
    }
}
