package app.bo.customer.web;

import app.bo.api.CustomerAJAXWebService;
import app.bo.api.customer.CreateCustomerAJAXRequest;
import app.bo.api.customer.CreateCustomerAJAXResponse;
import app.bo.api.customer.DeleteCustomerAJAXResponse;
import app.bo.api.customer.GetCustomerAJAXResponse;
import app.bo.api.customer.UpdateCustomerAJAXRequest;
import app.bo.api.customer.UpdateCustomerAJAXResponse;
import app.bo.customer.service.CustomerService;
import core.framework.inject.Inject;

/**
 * @author Ethan
 */
public class CustomerAJAXWebServiceImpl implements CustomerAJAXWebService {
    @Inject
    CustomerService customerService;

    @Override
    public GetCustomerAJAXResponse get(Long id) {
        return customerService.get(id);
    }

    @Override
    public CreateCustomerAJAXResponse create(CreateCustomerAJAXRequest request) {
        return customerService.create(request);
    }

    @Override
    public UpdateCustomerAJAXResponse update(Long id, UpdateCustomerAJAXRequest request) {
        return customerService.update(id, request);
    }

    @Override
    public DeleteCustomerAJAXResponse delete(Long id) {
        return customerService.delete(id);
    }
}
