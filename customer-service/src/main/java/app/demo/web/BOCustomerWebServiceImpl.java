package app.demo.web;

import app.demo.api.BOCustomerWebService;
import app.demo.api.customer.BOCreateCustomerRequest;
import app.demo.api.customer.BOCreateCustomerResponse;
import app.demo.api.customer.BODeleteCustomerResponse;
import app.demo.api.customer.BOGetCustomerResponse;
import app.demo.api.customer.BOUpdateCustomerRequest;
import app.demo.api.customer.BOUpdateCustomerResponse;
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
        return null;
    }

    @Override
    public BOCreateCustomerResponse create(BOCreateCustomerRequest request) {
        return boCustomerService.create(request);
    }

    @Override
    public BOUpdateCustomerResponse update(Long id, BOUpdateCustomerRequest request) {
        return null;
    }

    @Override
    public BODeleteCustomerResponse delete(Long id) {
        return null;
    }
}
