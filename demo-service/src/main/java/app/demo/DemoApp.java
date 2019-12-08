package app.demo;

import app.demo.api.customer.CreateCustomerRequest;
import app.demo.service.CustomerService;
import core.framework.inject.Inject;
import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author Ethan
 */
public class DemoApp extends App {


    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
//        load(new DemoModule());
        load(new CustomerModule());

    }
}
