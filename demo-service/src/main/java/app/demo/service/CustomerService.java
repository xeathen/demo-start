package app.demo.service;

import app.demo.api.customer.CreateCustomerRequest;
import app.demo.api.customer.CreateCustomerResponse;
import app.demo.domain.Customer;
import app.demo.domain.CustomerStatus;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.ConflictException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Ethan
 */
public class CustomerService {
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Inject
    Repository<Customer> customerRepository;

    public CreateCustomerResponse create(CreateCustomerRequest request) {
        logger.warn(request.email);
        logger.warn(customerRepository.toString());
        Optional<Customer> existingCustomer = customerRepository.selectOne("email = ?", request.email);
        if (existingCustomer.isPresent()) {
            throw new ConflictException("customer already exists, email=" + request.email);
        }
        Customer customer = new Customer();
        customer.status = CustomerStatus.ACTIVE;
        customer.email = request.email;
        customer.firstName = request.firstName;
        customer.lastName = request.lastName;
        customer.updatedTime = LocalDateTime.now();
        customer.id = customerRepository.insert(customer).orElseThrow();
        logger.debug(customer.toString() + "," + customer.firstName);
        CreateCustomerResponse response = new CreateCustomerResponse();
        response.id = customer.id;
        response.email = customer.email;
        response.firstName = customer.firstName;
        response.lastName = customer.lastName;
        return response;
    }


}
