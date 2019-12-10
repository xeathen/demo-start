package app.demo.api.customer;

import core.framework.api.json.Property;

/**
 * @author xeathen
 * @date 2019/12/8 16:52
 */
public class DeleteCustomerResponse {
    @Property(name = "id")
    public Long id;

    @Property(name = "email")
    public String email;
}
