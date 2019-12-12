package app.demo.web;

import app.customer.api.BOCustomerWebService;
import app.customer.api.customer.BOCreateCustomerRequest;
import app.customer.api.customer.BOCreateCustomerResponse;
import app.customer.api.customer.BODeleteCustomerResponse;
import app.customer.api.customer.BOGetCustomerResponse;
import app.customer.api.customer.BOUpdateCustomerRequest;
import app.customer.api.customer.BOUpdateCustomerResponse;
import app.demo.service.BOCustomerService;
import core.framework.inject.Inject;

/**
 * @author Ethan
 */
public class BOCustomerWebServiceImpl implements BOCustomerWebService {
    @Inject
    BOCustomerService boCustomerService;

    @Override
    public BOGetCustomerResponse get(Long id) {
        return boCustomerService.get(id);
    }

    @Override
    public BOCreateCustomerResponse create(BOCreateCustomerRequest request) {
        return boCustomerService.create(request);
    }

    @Override
    public BOUpdateCustomerResponse update(Long id, BOUpdateCustomerRequest request) {
        return boCustomerService.update(id, request);
    }

    @Override
    public BODeleteCustomerResponse delete(Long id) {
        return boCustomerService.delete(id);
    }
}
