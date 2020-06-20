package app.project;

import app.AppController;
import app.login.LoginController;
import app.util.*;
import spark.*;
import java.time.Instant;
import java.util.*;

public class ProjectController extends AppController {
    public static Route index = (Request request, Response response) -> {
        List<Project> projects = ProjectDao.findAll();
        Map<String, Object> model = new HashMap<>();
        model.put("projects", projects);

        return ViewUtil.render(request, model, Path.Template.PROJECTS);
    };

    public static Route add = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();

        return ViewUtil.render(request, model, Path.Template.PROJECT_ADD);
    };

    public static Route create = (Request request, Response response) -> {
        Project project = new Project();
        project.setName(request.queryParams("name"));
        project.activate();
        project.setCreatedIn(Instant.now());
        project.setCreatedBy(LoginController.getUser(request));
        ProjectDao.create(ProjectTranslator.translate(project));
        response.redirect("/projects/");

        return null;
    };

    public static Route edit = (Request request, Response response) -> {
        Project project = ProjectDao.find(Integer.parseInt(request.params(":id")));
        Map<String, Object> model = new HashMap<>();
        model.put("project", project);

        return ViewUtil.render(request, model, Path.Template.PROJECT_EDIT);
    };

    public static Route update = (Request request, Response response) -> {
        Project project = ProjectDao.find(Integer.parseInt(request.params(":id")));
        project.setName(request.queryParams("name"));
        project.setUpdatedIn(Instant.now());
        project.setUpdatedBy(LoginController.getUser(request));
        ProjectDao.update(ProjectTranslator.translate(project));
        response.redirect("/projects/");

        return null;
    };

    public static Route delete = (Request request, Response response) -> {
        Project project = ProjectDao.find(Integer.parseInt(request.params(":id")));
        project.deactivate();
        ProjectDao.update(ProjectTranslator.translate(project));
        response.redirect("/projects/");

        return null;
    };
}