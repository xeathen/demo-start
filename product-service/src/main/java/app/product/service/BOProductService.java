package app.product.service;

import app.product.api.product.BOCreateProductRequest;
import app.product.api.product.BOCreateProductResponse;
import app.product.api.product.BODeleteProductResponse;
import app.product.api.product.BOGetProductResponse;
import app.product.api.product.BOUpdateProductRequest;
import app.product.api.product.BOUpdateProductResponse;
import app.product.domain.Product;
import core.framework.inject.Inject;
import core.framework.mongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Ethan
 */
public class BOProductService {
    private final Logger logger = LoggerFactory.getLogger(BOProductService.class);
    @Inject
    MongoCollection<Product> productCollection;

    public BOGetProductResponse get(Long id) {
        BOGetProductResponse response = new BOGetProductResponse();
        Optional<Product> product = productCollection.get(id);
        response.id = product.get().id;
        response.name = product.get().name;
        response.description = product.get().description;
        return response;
    }

    public BOCreateProductResponse create(BOCreateProductRequest request) {
        Product product = new Product();
        product.id = UUID.randomUUID().toString();
        product.name = "The Burger";
        product.description = "This is a burger";
        productCollection.insert(product);
        return null;
    }

    public BOUpdateProductResponse update(Long id, BOUpdateProductRequest request) {
        return null;
    }

    public BODeleteProductResponse delete(Long id) {
        return null;
    }
}
