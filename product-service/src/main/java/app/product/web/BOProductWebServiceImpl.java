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
import core.framework.log.ActionLogContext;

/**
 * @author Ethan
 */
public class BOProductWebServiceImpl implements BOProductWebService {
    @Inject
    BOProductService boProductService;

    @Override
    public BOGetProductResponse get(String id) {
        ActionLogContext.put("productId", id);
        return boProductService.get(id);
    }

    @Override
    public BOCreateProductResponse create(BOCreateProductRequest request) {
        ActionLogContext.put("productId", request.name);
        return boProductService.create(request);
    }

    @Override
    public BOUpdateProductResponse update(String id, BOUpdateProductRequest request) {
        ActionLogContext.put("productId", id);
        ActionLogContext.put("productName", request.name);
        return boProductService.update(id, request);
    }

    @Override
    public BODeleteProductResponse delete(String id) {
        ActionLogContext.put("productId", id);
        return boProductService.delete(id);
    }
}
