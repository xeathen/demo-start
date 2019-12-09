package app.product.api.product;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

/**
 * @author Ethan
 */
public class UpdateProductRequest {
    @NotNull
    @NotBlank
    @Property(name = "name")
    public String name;

    @Property(name = "desc")
    public String description;
}
