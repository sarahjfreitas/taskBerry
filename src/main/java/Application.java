import static spark.debug.DebugScreen.*;
import static spark.Spark.*;

import app.index.IndexController;
import app.project.ProjectController;
import app.util.*;

public class Application {
    public static void main(String[] args){
        // dependencies

        // configuration
        port(2912);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        enableDebugScreen();

        // before-filters (called before each get/post)
        before("*", Filters.addTrailingSlashes);
        before("*", Filters.handleLocaleChange);

        // routes
        get("/projects/", ProjectController.index);
        get("/projects/new/", ProjectController.add);
        get("/projects/edit/:id/", ProjectController.edit);
        post("/projects/",ProjectController.create);
        post("/projects/edit/:id/", ProjectController.update);
        get("/projects/delete/:id/", ProjectController.delete);

        get("*", IndexController.index);
        

        // after-filters (called after each get/post)
        after("*", Filters.addGzipHeader);
    }
}