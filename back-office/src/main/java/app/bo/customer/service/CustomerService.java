package app.bo.customer.service;

import app.bo.api.customer.CreateCustomerAJAXRequest;
import app.bo.api.customer.CreateCustomerAJAXResponse;
import app.bo.api.customer.DeleteCustomerAJAXResponse;
import app.bo.api.customer.GetCustomerAJAXResponse;
import app.bo.api.customer.UpdateCustomerAJAXRequest;
import app.bo.api.customer.UpdateCustomerAJAXResponse;
import app.customer.api.BOCustomerWebService;
import app.customer.api.customer.BOCreateCustomerRequest;
import app.customer.api.customer.BOCreateCustomerResponse;
import app.customer.api.customer.BODeleteCustomerResponse;
import app.customer.api.customer.BOGetCustomerResponse;
import app.customer.api.customer.BOUpdateCustomerRequest;
import app.customer.api.customer.BOUpdateCustomerResponse;
import core.framework.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ethan
 */
public class CustomerService {
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Inject
    BOCustomerWebService boCustomerWebService;

    public GetCustomerAJAXResponse get(Long id) {
        GetCustomerAJAXResponse response = new GetCustomerAJAXResponse();
        BOGetCustomerResponse boResponse = boCustomerWebService.get(id);
        response.id = boResponse.id;
        response.email = boResponse.email;
        response.firstName = boResponse.firstName;
        response.lastName = boResponse.lastName;
        return response;
    }

    public CreateCustomerAJAXResponse create(CreateCustomerAJAXRequest request) {
        CreateCustomerAJAXResponse response = new CreateCustomerAJAXResponse();
        BOCreateCustomerRequest boRequest = new BOCreateCustomerRequest();
        boRequest.email = request.email;
        boRequest.firstName = request.firstName;
        boRequest.lastName = request.firstName;
        BOCreateCustomerResponse boResponse = boCustomerWebService.create(boRequest);
        response.id = boResponse.id;
        return response;
    }

    public UpdateCustomerAJAXResponse update(Long id, UpdateCustomerAJAXRequest request) {
        UpdateCustomerAJAXResponse response = new UpdateCustomerAJAXResponse();
        BOUpdateCustomerRequest boRequest = new BOUpdateCustomerRequest();
        boRequest.email = request.email;
        boRequest.firstName = request.firstName;
        boRequest.lastName = request.firstName;
        response.id = id;
        BOUpdateCustomerResponse boResponse = boCustomerWebService.update(id, boRequest);
        response.email = boResponse.email;
        response.firstName = boResponse.firstName;
        response.lastName = boResponse.firstName;
        return response;
    }

    public DeleteCustomerAJAXResponse delete(Long id) {
        DeleteCustomerAJAXResponse response = new DeleteCustomerAJAXResponse();
        BODeleteCustomerResponse boResponse = boCustomerWebService.delete(id);
        response.id = boResponse.id;
        return response;
    }
}
