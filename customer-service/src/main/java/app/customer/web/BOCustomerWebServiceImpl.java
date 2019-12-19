package app.customer.web;

import app.customer.api.BOCustomerWebService;
import app.customer.api.customer.BOCreateCustomerRequest;
import app.customer.api.customer.BOCreateCustomerResponse;
import app.customer.api.customer.BODeleteCustomerResponse;
import app.customer.api.customer.BOGetCustomerResponse;
import app.customer.api.customer.BOUpdateCustomerRequest;
import app.customer.api.customer.BOUpdateCustomerResponse;
import app.customer.service.BOCustomerService;
import core.framework.inject.Inject;
import core.framework.log.ActionLogContext;

/**
 * @author Ethan
 */
public class BOCustomerWebServiceImpl implements BOCustomerWebService {
    @Inject
    BOCustomerService boCustomerService;

    @Override
    public BOGetCustomerResponse get(Long id) {
        ActionLogContext.put("customerId", id);
        return boCustomerService.get(id);
    }

    @Override
    public BOCreateCustomerResponse create(BOCreateCustomerRequest request) {
        ActionLogContext.put("customerEmail", request.email);
        return boCustomerService.create(request);
    }

    @Override
    public BOUpdateCustomerResponse update(Long id, BOUpdateCustomerRequest request) {
        ActionLogContext.put("customerId", id);
        ActionLogContext.put("customerEmail", request.email);
        return boCustomerService.update(id, request);
    }

    @Override
    public BODeleteCustomerResponse delete(Long id) {
        ActionLogContext.put("customerId", id);
        return boCustomerService.delete(id);
    }
}
