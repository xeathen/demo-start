package app.bo.product.service;

import app.bo.api.product.CreateProductAJAXRequest;
import app.bo.api.product.CreateProductAJAXResponse;
import app.bo.api.product.DeleteProductAJAXResponse;
import app.bo.api.product.GetProductAJAXResponse;
import app.bo.api.product.UpdateProductAJAXRequest;
import app.bo.api.product.UpdateProductAJAXResponse;
import app.product.api.BOProductWebService;
import app.product.api.product.BOCreateProductRequest;
import app.product.api.product.BOCreateProductResponse;
import app.product.api.product.BODeleteProductResponse;
import app.product.api.product.BOGetProductResponse;
import app.product.api.product.BOUpdateProductRequest;
import app.product.api.product.BOUpdateProductResponse;
import core.framework.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ethan
 */
public class ProductService {
    private final Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Inject
    BOProductWebService boProductWebService;

    public GetProductAJAXResponse get(String id) {
        GetProductAJAXResponse response = new GetProductAJAXResponse();
        BOGetProductResponse boResponse = boProductWebService.get(id);
        response.id = id;
        response.name = boResponse.name;
        response.description = boResponse.description;
        return response;
    }

    public CreateProductAJAXResponse create(CreateProductAJAXRequest request) {
        CreateProductAJAXResponse response = new CreateProductAJAXResponse();
        BOCreateProductRequest boRequest = new BOCreateProductRequest();
        boRequest.name = request.name;
        boRequest.description = request.description;
        BOCreateProductResponse boResponse = boProductWebService.create(boRequest);
        response.id = boResponse.id;
        return response;
    }

    public UpdateProductAJAXResponse update(String id, UpdateProductAJAXRequest request) {
        UpdateProductAJAXResponse response = new UpdateProductAJAXResponse();
        BOUpdateProductRequest boRequest = new BOUpdateProductRequest();
        boRequest.name = request.name;
        boRequest.description = request.description;
        BOUpdateProductResponse boResponse = boProductWebService.update(id, boRequest);
        response.id = id;
        response.name = boResponse.name;
        response.description = boResponse.description;
        return response;
    }

    public DeleteProductAJAXResponse delete(String id) {
        DeleteProductAJAXResponse response = new DeleteProductAJAXResponse();
        BODeleteProductResponse boResponse = boProductWebService.delete(id);
        response.id = boResponse.id;
        return response;
    }
}
