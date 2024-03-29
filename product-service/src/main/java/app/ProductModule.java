package app;

import app.job.ProductJob;
import app.product.api.BOProductWebService;
import app.product.api.ProductWebService;
import app.product.domain.Product;
import app.product.service.BOProductService;
import app.product.service.ProductService;
import app.product.web.BOProductWebServiceImpl;
import app.product.web.ProductWebServiceImpl;
import core.framework.api.http.HTTPStatus;
import core.framework.module.Module;
import core.framework.mongo.module.MongoConfig;
import core.framework.web.Response;

import java.time.Duration;

import static core.framework.http.HTTPMethod.GET;

/**
 * @author Ethan
 */
public class ProductModule extends Module {
    @Override
    protected void initialize() {
        MongoConfig config = config(MongoConfig.class);
        config.uri(requiredProperty("sys.mongo.uri"));
        config.collection(Product.class);
        bind(ProductService.class);
        bind(BOProductService.class);
        api().service(ProductWebService.class, bind(ProductWebServiceImpl.class));
        api().service(BOProductWebService.class, bind(BOProductWebServiceImpl.class));
//        ProductService bean = bean(ProductService.class);
//        bean.publish();
        schedule().fixedRate("publish-job", bind(ProductJob.class), Duration.ofSeconds(2));
        http().route(GET, "/hello", request -> Response.text("hello").status(HTTPStatus.CREATED));
    }
}
