package app.product.service;

import app.product.api.kafka.ProductCreatedMessage;
import app.product.api.product.CreateProductRequest;
import app.product.api.product.CreateProductResponse;
import app.product.api.product.DeleteProductResponse;
import app.product.api.product.GetProductResponse;
import app.product.api.product.UpdateProductRequest;
import app.product.api.product.UpdateProductResponse;
import app.product.domain.Product;
import core.framework.async.Executor;
import core.framework.inject.Inject;
import core.framework.kafka.MessagePublisher;
import core.framework.mongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Ethan
 */
public class ProductService {
    private final Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Inject
    MongoCollection<Product> productCollection;
    @Inject
    Executor executor;
    @Inject
    MessagePublisher<ProductCreatedMessage> publisher;

    public GetProductResponse get(String id) {
        GetProductResponse response = new GetProductResponse();
        Optional<Product> product = productCollection.get(id);
        response.id = product.get().id;
        response.name = product.get().name;
        response.description = product.get().description;
        return response;
    }

    public CreateProductResponse create(CreateProductRequest request) {
        CreateProductResponse response = new CreateProductResponse();
        Product product = new Product();
        product.id = UUID.randomUUID().toString();
        response.id = product.id;
        product.name = request.name;
        product.description = request.description;
        productCollection.insert(product);
        return response;
    }

    public UpdateProductResponse update(String id, UpdateProductRequest request) {
        UpdateProductResponse response = new UpdateProductResponse();
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

    public DeleteProductResponse delete(String id) {
        DeleteProductResponse response = new DeleteProductResponse();
        response.id = id;
        productCollection.delete(id);
        return response;
    }

    public void printCurrentTime() {
        executor.submit("product-created", () -> {
            logger.warn(ZonedDateTime.now().toString());
        });
    }

    public void publish() {
        String productId = UUID.randomUUID().toString();
        ProductCreatedMessage message = new ProductCreatedMessage();
        message.productId = productId;
        message.productMadeDate = ZonedDateTime.now();
        publisher.publish(productId, message);
    }
}
