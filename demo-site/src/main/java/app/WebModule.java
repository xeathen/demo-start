package app;

import core.framework.api.http.HTTPStatus;
import core.framework.module.Module;
import core.framework.web.Response;

import static core.framework.http.HTTPMethod.GET;

/**
 * @author xeathen
 * @date 2019/12/8 20:35
 */
public class WebModule extends Module {

    @Override
    protected void initialize() {

        http().route(GET, "/hello", request -> Response.text("hello").status(HTTPStatus.CREATED));
    }
}
