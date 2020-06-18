import static spark.debug.DebugScreen.*;
import static spark.Spark.*;

import app.comment.CommentController;
import app.index.IndexController;
import app.issue.IssueController;
import app.project.ProjectController;
import app.task.TaskController;
import app.user.UserController;
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

        get("/tasks/", TaskController.index);
        get("/tasks/new/", TaskController.add);
        get("/tasks/edit/:id/", TaskController.edit);
        post("/tasks/",TaskController.create);
        post("/tasks/edit/:id/", TaskController.update);
        post("/tasks/description/:id/", TaskController.updateDescription);
        post("/tasks/workflow/:id/", TaskController.updateWorkflow);
        get("/tasks/delete/:id/", TaskController.delete);
        get("/tasks/view/:id/", TaskController.view);
        post("/comments/", CommentController.create);
        post("/issues/", IssueController.create);

        get("/users/", UserController.index);
        get("/users/new/", UserController.add);
        get("/users/edit/:id/", UserController.edit);
        post("/users/",UserController.create);
        post("/users/edit/:id/", UserController.update);
        get("/users/delete/:id/", UserController.delete);

        get("*", IndexController.index);
        

        // after-filters (called after each get/post)
        after("*", Filters.addGzipHeader);
    }
}