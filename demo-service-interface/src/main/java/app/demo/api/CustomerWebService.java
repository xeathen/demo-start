package app.demo.api;

import app.demo.api.customer.CreateCustomerRequest;
import app.demo.api.customer.CreateCustomerResponse;
import app.demo.api.customer.DeleteCustomerResponse;
import app.demo.api.customer.GetCustomerResponse;
import app.demo.api.customer.UpdateCustomerRequest;
import app.demo.api.customer.UpdateCustomerResponse;
import core.framework.api.http.HTTPStatus;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.PUT;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;
import core.framework.api.web.service.ResponseStatus;

/**
 * @author xeathen
 * @date 2019/12/8 16:45
 */
public interface CustomerWebService {
    @GET
    @Path("/customer/:id")
    GetCustomerResponse get(@PathParam("id") Long id);

    @POST
    @Path("/customer")
    @ResponseStatus(HTTPStatus.CREATED)
    CreateCustomerResponse create(CreateCustomerRequest request);

    @PUT
    @Path("/customer/:id")
    UpdateCustomerResponse update(@PathParam("id") Long id, UpdateCustomerRequest request);

    @DELETE
    @Path("/customer/:id")
    DeleteCustomerResponse delete(@PathParam("id") Long id);
}
