package app;

import app.demo.api.CustomerWebService;
import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author xeathen
 * @date 2019/12/8 20:34
 */
public class DemoSiteApp extends App {

    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        loadProperties("app.properties");

        http().gzip();
        http().httpPort(8443);
        http().access().denyFromFile("deny-ip-list.txt");

        site().security();
        log().maskFields("password");

        api().client(CustomerWebService.class, requiredProperty("app.customerWebService.URL"));
        load(new WebModule());
    }
}
