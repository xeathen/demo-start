package app.bo.api.customer;

import core.framework.api.json.Property;

/**
 * @author xeathen
 * @date 2019/12/8 16:51
 */
public class UpdateCustomerAJAXResponse {
    @Property(name = "id")
    public Long id;

    @Property(name = "email")
    public String email;

    @Property(name = "first_name")
    public String firstName;

    @Property(name = "last_name")
    public String lastName;
}
