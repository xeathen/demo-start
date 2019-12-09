package app.product.api.product;

import core.framework.api.json.Property;

/**
 * @author Ethan
 */
public class UpdateProductResponse {
    @Property(name = "id")
    public String id;

    @Property(name = "name")
    public String name;

    @Property(name = "desc")
    public String description;
}
