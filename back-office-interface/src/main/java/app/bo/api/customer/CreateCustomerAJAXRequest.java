package app.bo.api.customer;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

/**
 * @author Ethan
 */
public class CreateCustomerAJAXRequest {
    @NotNull
    @NotBlank
    @Property(name = "email")
    public String email;

    @NotNull
    @NotBlank
    @Property(name = "first_name")
    public String firstName;

    @NotBlank
    @Property(name = "last_name")
    public String lastName;
}

