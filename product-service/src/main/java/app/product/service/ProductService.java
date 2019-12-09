package app.product.service;

import app.product.domain.Product;
import core.framework.inject.Inject;
import core.framework.mongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author Ethan
 */
public class ProductService {
    private final Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Inject
    MongoCollection<Product> productCollection;

    public void create() {
        Product product = new Product();
        product.id = UUID.randomUUID().toString();
        product.name = "The Burger";
        product.description = "This is a burger";
        productCollection.insert(product);
    }
}
