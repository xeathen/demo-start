package app.bo.api.product;

import core.framework.api.json.Property;

/**
 * @author Ethan
 */
public class GetProductAJAXResponse {
    @Property(name = "id")
    public String id;

    @Property(name = "name")
    public String name;

    @Property(name = "desc")
    public String description;
}
