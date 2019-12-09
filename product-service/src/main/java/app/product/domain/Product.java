package app.product.domain;

import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;
import core.framework.mongo.Collection;
import core.framework.mongo.Field;
import core.framework.mongo.Id;

/**
 * @author Ethan
 */
@Collection(name = "products")
public class Product {
    @Id
    public String id;

    @NotNull
    @NotBlank
    @Field(name = "name")
    public String name;

    @Field(name = "desc")
    public String description;
}
