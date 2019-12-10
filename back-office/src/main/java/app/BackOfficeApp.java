package app;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author Ethan
 */
public class BackOfficeApp extends App {

    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        loadProperties("app.properties");
//        http().gzip();
//        http().httpPort(8443);
//        http().access().denyFromFile("deny-ip-list.txt");
//        site().security();
//        log().maskFields("password");
        load(new BackOfficeModule());
    }
}
