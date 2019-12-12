package app.customer.web;

import app.customer.api.CustomerWebService;
import app.customer.api.customer.CreateCustomerRequest;
import app.customer.api.customer.CreateCustomerResponse;
import app.customer.api.customer.DeleteCustomerResponse;
import app.customer.api.customer.GetCustomerResponse;
import app.customer.api.customer.UpdateCustomerRequest;
import app.customer.api.customer.UpdateCustomerResponse;
import app.customer.service.CustomerService;
import core.framework.inject.Inject;

/**
 * @author xeathen
 * @date 2019/12/8 17:30
 */
public class CustomerWebServiceImpl implements CustomerWebService {
    @Inject
    CustomerService customerService;

    @Override
    public GetCustomerResponse get(Long id) {
        return customerService.get(id);
    }

    @Override
    public CreateCustomerResponse create(CreateCustomerRequest request) {
        return customerService.create(request);
    }

    @Override
    public UpdateCustomerResponse update(Long id, UpdateCustomerRequest request) {
        return customerService.update(id, request);
    }

    @Override
    public DeleteCustomerResponse delete(Long id) {
        return customerService.delete(id);
    }
}
