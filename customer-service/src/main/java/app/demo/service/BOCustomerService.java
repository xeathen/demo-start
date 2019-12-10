package app.demo.service;

import app.demo.api.customer.BOCreateCustomerRequest;
import app.demo.api.customer.BOCreateCustomerResponse;
import app.demo.api.customer.BODeleteCustomerResponse;
import app.demo.api.customer.BOGetCustomerResponse;
import app.demo.api.customer.BOUpdateCustomerRequest;
import app.demo.api.customer.BOUpdateCustomerResponse;
import app.demo.domain.Customer;
import app.demo.domain.CustomerStatus;
import core.framework.api.web.service.PathParam;
import core.framework.db.Database;
import core.framework.db.Repository;
import core.framework.db.Transaction;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @author Ethan
 */
public class BOCustomerService {
    private final Logger logger = LoggerFactory.getLogger(BOCustomerService.class);
    @Inject
    Repository<Customer> customerRepository;
    @Inject
    Database database;

    public BOGetCustomerResponse get(@PathParam("id") Long id) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found, id=" + id));
        BOGetCustomerResponse response = new BOGetCustomerResponse();
        response.id = id;
        response.email = customer.email;
        response.firstName = customer.firstName;
        response.lastName = customer.lastName;
        return response;
    }

    /**
     * 事务使用实例
     */
    public BOCreateCustomerResponse create(BOCreateCustomerRequest request) {
        BOCreateCustomerResponse response = new BOCreateCustomerResponse();
        try (Transaction transaction = database.beginTransaction()) {
            database.execute("insert into customers(status, email, first_name, last_name, updated_time) values(?, ?, ?, ?, ?)",
                CustomerStatus.ACTIVE, request.email, request.firstName, request.lastName, LocalDateTime.now());
            transaction.commit();
        }
        response.id = customerRepository.selectOne("email=?", request.email).orElseThrow(
            () -> new NotFoundException("customer not found, email=?" + request.email)).id;
        return response;
    }

    public BOUpdateCustomerResponse update(@PathParam("id") Long id, BOUpdateCustomerRequest request) {
        return null;
    }

    public BODeleteCustomerResponse delete(@PathParam("id") Long id) {
        return null;
    }
}
