package app.product.api.kafka;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

import java.time.ZonedDateTime;

/**
 * @author Ethan
 */
public class ProductCreatedMessage {
    @NotNull
    @NotBlank
    @Property(name = "product_id")
    public String productId;

    @NotNull
    @Property(name = "product_made_date")
    public ZonedDateTime productMadeDate;
}
