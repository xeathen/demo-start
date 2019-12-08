package app.demo.web;

import app.demo.api.CustomerWebService;
import app.demo.api.customer.CreateCustomerRequest;
import app.demo.api.customer.CreateCustomerResponse;
import app.demo.api.customer.DeleteCustomerRequest;
import app.demo.api.customer.DeleteCustomerResponse;
import app.demo.api.customer.GetCustomerResponse;
import app.demo.api.customer.UpdateCustomerRequest;
import app.demo.api.customer.UpdateCustomerResponse;
import app.demo.service.CustomerService;
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
//        return customerService.get(id);
        return null;
    }

    @Override
    public CreateCustomerResponse create(CreateCustomerRequest request) {
        return customerService.create(request);
    }

    @Override
    public UpdateCustomerResponse update(Long id, UpdateCustomerRequest request) {
//        return customerService.update(id, request);
        return null;
    }

    @Override
    public DeleteCustomerResponse delete(DeleteCustomerRequest request) {
        return null;
    }
}
