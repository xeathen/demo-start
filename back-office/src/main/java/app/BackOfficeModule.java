package app;

import app.bo.api.CustomerAJAXWebService;
import app.bo.api.ProductAJAXWebService;
import app.bo.customer.service.CustomerService;
import app.bo.customer.web.CustomerAJAXWebServiceImpl;
import app.bo.product.service.ProductService;
import app.bo.product.web.ProductAJAXWebServiceImpl;
import app.customer.api.BOCustomerWebService;
import app.product.api.BOProductWebService;
import core.framework.module.Module;

/**
 * @author Ethan
 */
public class BackOfficeModule extends Module {
    @Override
    protected void initialize() {
        api().client(BOCustomerWebService.class, requiredProperty("app.customerWebAJAXService.URL"));
        api().client(BOProductWebService.class, requiredProperty("app.productWebAJAXService.URL"));
        bind(CustomerService.class);
        bind(ProductService.class);
        api().service(CustomerAJAXWebService.class, bind(CustomerAJAXWebServiceImpl.class));
        api().service(ProductAJAXWebService.class, bind(ProductAJAXWebServiceImpl.class));
    }
}
