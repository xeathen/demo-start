package app.customer.service;

import app.customer.api.customer.CreateCustomerRequest;
import app.customer.api.customer.CreateCustomerResponse;
import app.customer.api.customer.DeleteCustomerResponse;
import app.customer.api.customer.GetCustomerResponse;
import app.customer.api.customer.SearchCustomerRequest;
import app.customer.api.customer.SearchCustomerResponse;
import app.customer.api.customer.UpdateCustomerRequest;
import app.customer.api.customer.UpdateCustomerResponse;
import app.customer.domain.Customer;
import app.customer.domain.CustomerStatus;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.util.Strings;
import core.framework.web.exception.ConflictException;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Ethan
 */
public class CustomerService {
    @Inject
    Repository<Customer> customerRepository;

    public SearchCustomerResponse search(SearchCustomerRequest request) {
        SearchCustomerResponse result = new SearchCustomerResponse();
        Query<Customer> query = customerRepository.select();
        query.skip(request.skip);
        query.limit(request.limit);
        if (!Strings.isBlank(request.email)) {
            query.where("email = ?", request.email);
        }
        if (!Strings.isBlank(request.firstName)) {
            query.where("first_name like ?", Strings.format("{}%", request.firstName));
        }
        if (!Strings.isBlank(request.lastName)) {
            query.where("last_name like ?", Strings.format("{}%", request.lastName));
        }
        result.customers = query.fetch().stream().map(this::convert).collect(Collectors.toList());
        result.total = query.count();
        return result;
    }

    public GetCustomerResponse get(Long id) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found, id=" + id));
        GetCustomerResponse response = new GetCustomerResponse();
        response.id = id;
        response.email = customer.email;
        response.firstName = customer.firstName;
        response.lastName = customer.lastName;
        return response;
    }

    public CreateCustomerResponse create(CreateCustomerRequest request) {
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
        CreateCustomerResponse response = new CreateCustomerResponse();
        response.id = customer.id;
        return response;
    }

    public UpdateCustomerResponse update(Long id, UpdateCustomerRequest request) {
        UpdateCustomerResponse response = new UpdateCustomerResponse();
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

    public DeleteCustomerResponse delete(Long id) {
        DeleteCustomerResponse response = new DeleteCustomerResponse();
        response.id = id;
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found, id=" + id));
        response.email = customer.email;
        customerRepository.delete(id);
        return response;
    }

    public GetCustomerResponse convert(Customer customer) {
        GetCustomerResponse result = new GetCustomerResponse();
        result.id = customer.id;
        result.email = customer.email;
        result.firstName = customer.firstName;
        result.lastName = customer.lastName;
        return result;
    }
}
