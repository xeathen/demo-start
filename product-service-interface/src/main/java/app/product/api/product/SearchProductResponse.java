package app.product.api.product;

import core.framework.api.json.Property;

import java.util.List;

/**
 * @author Ethan
 */
public class SearchProductResponse {
    @Property(name = "products")
    public List<GetProductResponse> products;
}
