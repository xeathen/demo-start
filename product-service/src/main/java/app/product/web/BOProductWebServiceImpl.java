package app.product.web;

import app.product.api.BOProductWebService;
import app.product.api.product.BOCreateProductRequest;
import app.product.api.product.BOCreateProductResponse;
import app.product.api.product.BODeleteProductResponse;
import app.product.api.product.BOGetProductResponse;
import app.product.api.product.BOUpdateProductRequest;
import app.product.api.product.BOUpdateProductResponse;
import app.product.service.BOProductService;
import core.framework.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ethan
 */
public class BOProductWebServiceImpl implements BOProductWebService {
    private final Logger logger = LoggerFactory.getLogger(BOProductWebServiceImpl.class);
    @Inject
    BOProductService boProductService;

    @Override
    public BOGetProductResponse get(String id) {
        return boProductService.get(id);
    }

    @Override
    public BOCreateProductResponse create(BOCreateProductRequest request) {
        return boProductService.create(request);
    }

    @Override
    public BOUpdateProductResponse update(String id, BOUpdateProductRequest request) {
        return boProductService.update(id, request);
    }

    @Override
    public BODeleteProductResponse delete(String id) {
        return boProductService.delete(id);
    }
}
