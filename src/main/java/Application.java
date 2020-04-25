import app.ControllerFactory;
import app.utils.Path;

import static spark.debug.DebugScreen.*;
import static spark.Spark.*;

public class Application {
    public static void main(String[] args){
        // Instantiate your dependencies
        ControllerFactory controllerFactory = new ControllerFactory();

        setServerConfiguration();

        // Set up before-filters (called before each get/post)
        //before("*",Filters.beforeFilter());

        // Set up routes
        get(Path.Web.INDEX, controllerFactory.IndexController().index());

        //Set up after-filters (called after each get/post)
        //after("*", Filters.afterFilter());
    }

    private static void setServerConfiguration(){
        port(4567);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        enableDebugScreen();
    }
}