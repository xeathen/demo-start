package app.bo.api;

import app.bo.api.customer.CreateCustomerAJAXRequest;
import app.bo.api.customer.CreateCustomerAJAXResponse;
import app.bo.api.customer.DeleteCustomerAJAXResponse;
import app.bo.api.customer.GetCustomerAJAXResponse;
import app.bo.api.customer.UpdateCustomerAJAXRequest;
import app.bo.api.customer.UpdateCustomerAJAXResponse;
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
public interface CustomerAJAXWebService {
    @GET
    @Path("/ajax/customer/:id")
    GetCustomerAJAXResponse get(@PathParam("id") Long id);

    @POST
    @Path("/ajax/customer")
    @ResponseStatus(HTTPStatus.CREATED)
    CreateCustomerAJAXResponse create(CreateCustomerAJAXRequest request);

    @PUT
    @Path("/ajax/customer/:id")
    UpdateCustomerAJAXResponse update(@PathParam("id") Long id, UpdateCustomerAJAXRequest request);

    @DELETE
    @Path("/ajax/customer/:id")
    DeleteCustomerAJAXResponse delete(@PathParam("id") Long id);
}
