package app.product.api;

import app.product.api.product.CreateProductRequest;
import app.product.api.product.CreateProductResponse;
import app.product.api.product.DeleteProductResponse;
import app.product.api.product.GetProductResponse;
import app.product.api.product.UpdateProductRequest;
import app.product.api.product.UpdateProductResponse;
import core.framework.api.http.HTTPStatus;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.PUT;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;
import core.framework.api.web.service.ResponseStatus;

/**
 * @author Ethan
 */
public interface ProductWebService {
    @GET
    @Path("/product/:id")
    GetProductResponse get(@PathParam("id") String id);

    @POST
    @Path("/product")
    @ResponseStatus(HTTPStatus.CREATED)
    CreateProductResponse create(CreateProductRequest request);

    @PUT
    @Path("/product/:id")
    UpdateProductResponse update(@PathParam("id") String id, UpdateProductRequest request);

    @DELETE
    @Path("/product/:id")
    DeleteProductResponse delete(@PathParam("id") String id);
}
