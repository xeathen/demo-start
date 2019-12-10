package app.bo.product.web;

import app.bo.api.ProductAJAXWebService;
import app.bo.api.product.CreateProductAJAXRequest;
import app.bo.api.product.CreateProductAJAXResponse;
import app.bo.api.product.DeleteProductAJAXResponse;
import app.bo.api.product.GetProductAJAXResponse;
import app.bo.api.product.UpdateProductAJAXRequest;
import app.bo.api.product.UpdateProductAJAXResponse;
import app.bo.product.service.ProductService;
import core.framework.inject.Inject;

/**
 * @author Ethan
 */
public class ProductAJAXWebServiceImpl implements ProductAJAXWebService {
    @Inject
    ProductService productService;

    @Override
    public GetProductAJAXResponse get(String id) {
        return productService.get(id);
    }

    @Override
    public CreateProductAJAXResponse create(CreateProductAJAXRequest request) {
        return productService.create(request);
    }

    @Override
    public UpdateProductAJAXResponse update(String id, UpdateProductAJAXRequest request) {
        return productService.update(id, request);
    }

    @Override
    public DeleteProductAJAXResponse delete(String id) {
        return productService.delete(id);
    }
}
