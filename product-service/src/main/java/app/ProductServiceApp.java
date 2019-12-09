package app;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author Ethan
 */
public class ProductServiceApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new ProductModule());
    }
}
