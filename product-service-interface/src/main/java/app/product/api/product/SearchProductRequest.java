package app.product.api.product;

import core.framework.api.validate.NotNull;
import core.framework.api.web.service.QueryParam;

/**
 * @author Ethan
 */
public class SearchProductRequest {
    @NotNull(message = "name is required")
    @QueryParam(name = "name")
    public String name;

    @QueryParam(name = "desc")
    public String description;
}
