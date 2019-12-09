package app.demo;

import app.demo.api.CustomerWebService;
import app.demo.domain.Customer;
import app.demo.service.CustomerService;
import app.demo.web.CustomerWebServiceImpl;
import core.framework.module.Module;

/**
 * @author xeathen
 * @date 2019/12/8 17:50
 */
public class CustomerModule extends Module {

    @Override
    protected void initialize() {
        db().repository(Customer.class);
        bind(CustomerService.class);
        api().service(CustomerWebService.class, bind(CustomerWebServiceImpl.class));
    }
}
