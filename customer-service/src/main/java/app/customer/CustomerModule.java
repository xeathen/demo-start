package app.customer;

import app.customer.api.BOCustomerWebService;
import app.customer.api.CustomerWebService;
import app.customer.domain.Customer;
import app.customer.service.BOCustomerService;
import app.customer.service.CustomerService;
import app.customer.web.BOCustomerWebServiceImpl;
import app.customer.web.CustomerWebServiceImpl;
import app.kafka.ProductCreatedMessageHandler;
import app.product.api.kafka.ProductCreatedMessage;
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
        bind(BOCustomerService.class);
        api().service(CustomerWebService.class, bind(CustomerWebServiceImpl.class));
        api().service(BOCustomerWebService.class, bind(BOCustomerWebServiceImpl.class));
        configureKafka();
    }

    private void configureKafka() {
        kafka().uri("localhost:9092");
        String topic = "product-created";
        kafka().subscribe(topic, ProductCreatedMessage.class, bind(ProductCreatedMessageHandler.class));
        kafka().poolSize(1);
    }
}
