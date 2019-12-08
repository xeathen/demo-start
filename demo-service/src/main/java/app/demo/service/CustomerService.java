package app.demo.service;

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

    public void create(Customer dto) {
        Optional<Customer> existingCustomer = customerRepository.selectOne("email = ?", dto.email);
        if (existingCustomer.isPresent()) {
            throw new ConflictException("customer already exists, email=" + dto.email);
        }
        Customer customer = new Customer();
        customer.status = CustomerStatus.ACTIVE;
        customer.email = dto.email;
        customer.firstName = dto.firstName;
        customer.lastName = dto.lastName;
        customer.updatedTime = LocalDateTime.now();
        customer.id = customerRepository.insert(customer).orElseThrow();
        logger.debug(customer.email);
    }
}
