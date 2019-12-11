package app;

import app.kafka.ProductCreatedMessageHandler;
import app.product.api.BOProductWebService;
import app.product.api.ProductWebService;
import app.product.api.kafka.ProductCreatedMessage;
import app.product.domain.Product;
import app.product.service.BOProductService;
import app.product.service.ProductService;
import app.product.web.BOProductWebServiceImpl;
import app.product.web.ProductWebServiceImpl;
import core.framework.module.Module;
import core.framework.mongo.module.MongoConfig;

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
        bean(ProductService.class).printCurrentTime();
        kafka().subscribe("product-created", ProductCreatedMessage.class, new ProductCreatedMessageHandler());
    }
}
