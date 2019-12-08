package app.demo;

import app.demo.demo.Painter;
import core.framework.module.App;
import core.framework.module.SystemModule;


/**
 * @author Ethan
 */
public class DemoApp extends App {

    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new DemoModule());
    }
}
