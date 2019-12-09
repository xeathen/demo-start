package app;

import app.product.domain.Product;
import app.product.service.ProductService;
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
//        bean(ProductService.class).create();
    }
}
