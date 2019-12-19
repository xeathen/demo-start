package app.customer.service;

import app.customer.api.customer.BOCreateCustomerRequest;
import app.customer.api.customer.BOCreateCustomerResponse;
import app.customer.api.customer.BODeleteCustomerResponse;
import app.customer.api.customer.BOGetCustomerResponse;
import app.customer.api.customer.BOUpdateCustomerRequest;
import app.customer.api.customer.BOUpdateCustomerResponse;
import app.customer.domain.Customer;
import app.customer.domain.CustomerStatus;
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

    public BOGetCustomerResponse get(Long id) {
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

    public BOUpdateCustomerResponse update(Long id, BOUpdateCustomerRequest request) {
        BOUpdateCustomerResponse response = new BOUpdateCustomerResponse();
        response.id = id;
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found, id=" + id));
        customer.updatedTime = LocalDateTime.now();
        customer.firstName = request.firstName;
        response.firstName = request.firstName;
        if (request.lastName != null) {
            customer.lastName = request.lastName;
            response.lastName = request.lastName;
        }
        customer.email = request.email;
        response.email = request.email;
        customerRepository.partialUpdate(customer);
        return response;
    }

    public BODeleteCustomerResponse delete(Long id) {
        BODeleteCustomerResponse response = new BODeleteCustomerResponse();
        response.id = id;
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found, id=" + id));
        response.email = customer.email;
        customerRepository.delete(id);
        return response;
    }
}
