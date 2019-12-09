package app.demo.api;

import app.demo.api.customer.BOCreateCustomerRequest;
import app.demo.api.customer.BOCreateCustomerResponse;
import app.demo.api.customer.BODeleteCustomerResponse;
import app.demo.api.customer.BOGetCustomerResponse;
import app.demo.api.customer.BOUpdateCustomerRequest;
import app.demo.api.customer.BOUpdateCustomerResponse;
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
 * @date 2019/12/8 17:18
 */
public interface BOCustomerWebService {
    @GET
    @Path("/bo/customer/:id")
    BOGetCustomerResponse get(@PathParam("id") Long id);

    @POST
    @Path("/bo/customer")
    @ResponseStatus(HTTPStatus.CREATED)
    BOCreateCustomerResponse create(BOCreateCustomerRequest request);

    @PUT
    @Path("/bo/customer/:id")
    BOUpdateCustomerResponse update(@PathParam("id") Long id, BOUpdateCustomerRequest request);

    @DELETE
    @Path("/bo/customer/:id")
    BODeleteCustomerResponse delete(@PathParam("id") Long id);
}
