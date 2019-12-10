package app.product.api;

import app.product.api.product.BOCreateProductRequest;
import app.product.api.product.BOCreateProductResponse;
import app.product.api.product.BODeleteProductResponse;
import app.product.api.product.BOGetProductResponse;
import app.product.api.product.BOUpdateProductRequest;
import app.product.api.product.BOUpdateProductResponse;
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
public interface BOProductWebService {
    @GET
    @Path("/bo/product/:id")
    BOGetProductResponse get(@PathParam("id") String id);

    @POST
    @Path("/bo/product")
    @ResponseStatus(HTTPStatus.CREATED)
    BOCreateProductResponse create(BOCreateProductRequest request);

    @PUT
    @Path("/bo/product/:id")
    BOUpdateProductResponse update(@PathParam("id") String id, BOUpdateProductRequest request);

    @DELETE
    @Path("/bo/product/:id")
    BODeleteProductResponse delete(@PathParam("id") String id);
}
