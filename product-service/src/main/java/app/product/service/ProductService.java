package app.product.service;

import app.product.api.kafka.ProductCreatedMessage;
import app.product.api.product.CreateProductRequest;
import app.product.api.product.CreateProductResponse;
import app.product.api.product.DeleteProductResponse;
import app.product.api.product.GetProductResponse;
import app.product.api.product.SearchProductRequest;
import app.product.api.product.SearchProductResponse;
import app.product.api.product.UpdateProductRequest;
import app.product.api.product.UpdateProductResponse;
import app.product.domain.Product;
import com.mongodb.client.model.Filters;
import core.framework.async.Executor;
import core.framework.inject.Inject;
import core.framework.kafka.MessagePublisher;
import core.framework.mongo.MongoCollection;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public SearchProductResponse search(SearchProductRequest request) {
        SearchProductResponse result = new SearchProductResponse();
        List<GetProductResponse> responseList = new ArrayList<>();
//        Query query = new Query();
        Bson name = Filters.eq("name", request.name);
//        query.filter = name;
//        productCollection.find(query).stream().forEach(product -> {
//            responseList.add(convert(product));
//        });
        result.products = productCollection.find(name).stream().map(this::convert).collect(Collectors.toList());
        return result;
    }

    public GetProductResponse get(String id) {
        GetProductResponse result = new GetProductResponse();
        Optional<Product> product = productCollection.get(id);
        result.id = product.get().id;
        result.name = product.get().name;
        result.description = product.get().description;
        return result;
    }

    public CreateProductResponse create(CreateProductRequest request) {
        CreateProductResponse result = new CreateProductResponse();
        Product product = new Product();
        product.id = UUID.randomUUID().toString();
        result.id = product.id;
        product.name = request.name;
        product.description = request.description;
        productCollection.insert(product);
        return result;
    }

    public UpdateProductResponse update(String id, UpdateProductRequest request) {
        UpdateProductResponse result = new UpdateProductResponse();
        Product product = new Product();
        product.id = id;
        result.id = id;
        product.name = request.name;
        result.name = request.name;
        product.description = request.description;
        result.description = request.description;
        productCollection.replace(product);
        return result;
    }

    public DeleteProductResponse delete(String id) {
        DeleteProductResponse result = new DeleteProductResponse();
        result.id = id;
        productCollection.delete(id);
        return result;
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

    public GetProductResponse convert(Product product) {
        GetProductResponse result = new GetProductResponse();
        result.id = product.id;
        result.name = product.name;
        result.description = product.description;
        return result;
    }
}
