package app.customer.api.customer;

import core.framework.api.json.Property;

import java.util.List;

/**
 * @author Ethan
 */
public class SearchCustomerResponse {
    @Property(name = "total")
    public Integer total;

    @Property(name = "customers")
    public List<GetCustomerResponse> customers;
}
