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

    public BOGetProductResponse get(String id) {
        BOGetProductResponse response = new BOGetProductResponse();
        Optional<Product> product = productCollection.get(id);
        response.id = product.get().id;
        response.name = product.get().name;
        response.description = product.get().description;
        return response;
    }

    public BOCreateProductResponse create(BOCreateProductRequest request) {
        BOCreateProductResponse response = new BOCreateProductResponse();
        Product product = new Product();
        product.id = UUID.randomUUID().toString();
        response.id = product.id;
        product.name = request.name;
        product.description = request.description;
        productCollection.insert(product);
        return response;
    }

    public BOUpdateProductResponse update(String id, BOUpdateProductRequest request) {
        BOUpdateProductResponse response = new BOUpdateProductResponse();
        Product product = new Product();
        product.id = id;
        response.id = id;
        product.name = request.name;
        response.name = request.name;
        product.description = request.description;
        response.description = request.description;
        productCollection.replace(product);
        return response;
    }

    public BODeleteProductResponse delete(String id) {
        BODeleteProductResponse response = new BODeleteProductResponse();
        response.id = id;
        productCollection.delete(id);
        return response;
    }
}
