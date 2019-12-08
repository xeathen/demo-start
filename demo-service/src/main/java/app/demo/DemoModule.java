package app.demo;

import app.demo.demo.Brush;
import app.demo.demo.Painter;
import app.demo.domain.Customer;
import app.demo.service.CustomerService;
import core.framework.module.DBConfig;
import core.framework.module.Module;

/**
 * @author Ethan
 */
public class DemoModule extends Module {


    @Override
    protected void initialize() {
        DBConfig db = db();
        db.repository(Customer.class);
        bind(CustomerService.class);
        bind(Brush.class);
        bind(Painter.class);
        bean(Painter.class).draw();
        bean(CustomerService.class).create(new Customer());
    }
}
