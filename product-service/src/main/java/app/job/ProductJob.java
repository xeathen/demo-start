package app.job;

import core.framework.scheduler.Job;
import core.framework.scheduler.JobContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;

/**
 * @author Ethan
 */
public class ProductJob implements Job {
    private final Logger logger = LoggerFactory.getLogger(ProductJob.class);

    @Override
    public void execute(JobContext context) throws Exception {
        logger.debug(ZonedDateTime.now().toString());
    }
}
