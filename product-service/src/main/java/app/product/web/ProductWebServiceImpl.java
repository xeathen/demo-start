package app.product.web;

import app.product.api.ProductWebService;
import app.product.api.product.CreateProductRequest;
import app.product.api.product.CreateProductResponse;
import app.product.api.product.DeleteProductResponse;
import app.product.api.product.GetProductResponse;
import app.product.api.product.UpdateProductRequest;
import app.product.api.product.UpdateProductResponse;
import app.product.service.ProductService;
import core.framework.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ethan
 */
public class ProductWebServiceImpl implements ProductWebService {
    private final Logger logger = LoggerFactory.getLogger(ProductWebServiceImpl.class);
    @Inject
    ProductService productService;

    @Override
    public GetProductResponse get(String id) {
        return productService.get(id);
    }

    @Override
    public CreateProductResponse create(CreateProductRequest request) {
        return productService.create(request);
    }

    @Override
    public UpdateProductResponse update(String id, UpdateProductRequest request) {
        return productService.update(id, request);
    }

    @Override
    public DeleteProductResponse delete(String id) {
        return productService.delete(id);
    }
}
