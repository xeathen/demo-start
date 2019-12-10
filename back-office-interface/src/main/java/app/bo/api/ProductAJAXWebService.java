package app.bo.api;

import app.bo.api.product.CreateProductAJAXRequest;
import app.bo.api.product.CreateProductAJAXResponse;
import app.bo.api.product.DeleteProductAJAXResponse;
import app.bo.api.product.GetProductAJAXResponse;
import app.bo.api.product.UpdateProductAJAXRequest;
import app.bo.api.product.UpdateProductAJAXResponse;
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
public interface ProductAJAXWebService {
    @GET
    @Path("/ajax/product/:id")
    GetProductAJAXResponse get(@PathParam("id") String id);

    @POST
    @Path("/ajax/product")
    @ResponseStatus(HTTPStatus.CREATED)
    CreateProductAJAXResponse create(CreateProductAJAXRequest request);

    @PUT
    @Path("/ajax/product/:id")
    UpdateProductAJAXResponse update(@PathParam("id") String id, UpdateProductAJAXRequest request);

    @DELETE
    @Path("/ajax/product/:id")
    DeleteProductAJAXResponse delete(@PathParam("id") String id);
}
