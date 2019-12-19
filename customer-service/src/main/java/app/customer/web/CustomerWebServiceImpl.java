package app.customer.web;

import app.customer.api.CustomerWebService;
import app.customer.api.customer.CreateCustomerRequest;
import app.customer.api.customer.CreateCustomerResponse;
import app.customer.api.customer.DeleteCustomerResponse;
import app.customer.api.customer.GetCustomerResponse;
import app.customer.api.customer.SearchCustomerRequest;
import app.customer.api.customer.SearchCustomerResponse;
import app.customer.api.customer.UpdateCustomerRequest;
import app.customer.api.customer.UpdateCustomerResponse;
import app.customer.service.CustomerService;
import core.framework.inject.Inject;
import core.framework.log.ActionLogContext;

/**
 * @author xeathen
 * @date 2019/12/8 17:30
 */
public class CustomerWebServiceImpl implements CustomerWebService {
    @Inject
    CustomerService customerService;

    @Override
    public SearchCustomerResponse search(SearchCustomerRequest request) {
        ActionLogContext.put("customerEmail", request.email);
        return customerService.search(request);
    }

    @Override
    public GetCustomerResponse get(Long id) {
        ActionLogContext.put("customerId", id);
        return customerService.get(id);
    }

    @Override
    public CreateCustomerResponse create(CreateCustomerRequest request) {
        ActionLogContext.put("customerEmail", request.email);
        return customerService.create(request);
    }

    @Override
    public UpdateCustomerResponse update(Long id, UpdateCustomerRequest request) {
        ActionLogContext.put("customerId", id);
        ActionLogContext.put("customerEmail", request.email);
        return customerService.update(id, request);
    }

    @Override
    public DeleteCustomerResponse delete(Long id) {
        ActionLogContext.put("customerId", id);
        return customerService.delete(id);
    }
}
