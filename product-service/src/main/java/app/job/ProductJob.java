package app.job;

import app.product.service.ProductService;
import core.framework.inject.Inject;
import core.framework.scheduler.Job;
import core.framework.scheduler.JobContext;

/**
 * @author Ethan
 */
public class ProductJob implements Job {
    @Inject
    ProductService productService;

    @Override
    public void execute(JobContext context) throws Exception {
//        logger.debug(ZonedDateTime.now().toString());
        productService.publish();
    }
}
