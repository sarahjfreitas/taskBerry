package app.task;

import app.AppController;
import app.comment.CommentDao;
import app.project.Project;
import app.project.ProjectDao;
import app.user.User;
import app.user.UserDao;
import app.user.UserTranslator;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
import java.time.Instant;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static app.util.JsonUtil.dataToJson;

public class TaskController extends AppController {
    public static Route index = (Request request, Response response) -> {
        List<Task> tasks = TaskDao.findAll();
        Map<String, Object> model = new HashMap<>();
        model.put("tasks", tasks);

        return ViewUtil.render(request, model, Path.Template.TASKS);
    };

    public static Route add = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        List<Project> projects = ProjectDao.findAll();
        List<User> users = UserTranslator.translate(UserDao.findActives());
        model.put("projects", projects);
        model.put("users", users);

        return ViewUtil.render(request, model, Path.Template.TASK_ADD);
    };

    public static Route create = (Request request, Response response) -> {
        TaskData task = new TaskData();
        task.name = request.queryParams("name");
        task.description = request.queryParams("description");
        task.responsible = Integer.parseInt(request.queryParams("responsible"));
        task.createdIn = Instant.now().getEpochSecond();
        task.currentStatus = Status.PENDING.toString();
        task.projectId = Integer.parseInt(request.queryParams("projectId"));

        TaskDao.create(task);
        response.redirect("/tasks/");

        return dataToJson(task);
    };

    public static Route edit = (Request request, Response response) -> {
        Task task = TaskDao.find(Integer.parseInt(request.params(":id")));
        Map<String, Object> model = new HashMap<>();
        EnumSet statuses = EnumSet.allOf(Status.class);
        List<User> users = UserTranslator.translate(UserDao.findActives());

        model.put("users", users);
        model.put("task", task);
        model.put("statuses", statuses);

        return ViewUtil.render(request, model, Path.Template.TASK_EDIT);
    };

    public static Route update = (Request request, Response response) -> {
        TaskData task = TaskTranslator.translate(TaskDao.find(Integer.parseInt(request.params(":id"))));
        task.name = request.queryParams("name");
        task.description = request.queryParams("description");
        task.responsible = Integer.parseInt(request.queryParams("responsible"));
        task.updatedIn = Instant.now().getEpochSecond();
        task.currentStatus = request.queryParams("currentStatus");
        TaskDao.update(task);
        response.redirect("/tasks/");

        return dataToJson(task);
    };

    public static Route updateDescription = (Request request, Response response) -> {
        TaskData task = TaskTranslator.translate(TaskDao.find(Integer.parseInt(request.params(":id"))));
        task.description = request.queryParams("description");
        task.updatedIn = Instant.now().getEpochSecond();
        TaskDao.update(task);
        response.redirect("/tasks/view/"+task.taskId);

        return dataToJson(task);
    };

    public static Route updateWorkflow = (Request request, Response response) -> {
        TaskData task = TaskTranslator.translate(TaskDao.find(Integer.parseInt(request.params(":id"))));
        task.responsible = Integer.parseInt(request.queryParams("responsible"));
        task.updatedIn = Instant.now().getEpochSecond();
        task.currentStatus = request.queryParams("currentStatus");
        TaskDao.update(task);
        response.redirect("/tasks/view/"+task.taskId);

        return dataToJson(task);
    };


    public static Route delete = (Request request, Response response) -> {
        TaskDao.delete(Integer.parseInt(request.params(":id")));
        response.redirect("/tasks/");

        return null;
    };

    public static Route view = (Request request, Response response) -> {
        Task task = TaskDao.find(Integer.parseInt(request.params(":id")));
        EnumSet statuses = EnumSet.allOf(Status.class);
        List<User> users = UserTranslator.translate(UserDao.findActives());
        Map<String, Object> model = new HashMap<>();
        task.setComments(CommentDao.findByTask(task.getTaskId()));
        model.put("task", task);
        model.put("users", users);
        model.put("statuses", statuses);

        return ViewUtil.render(request, model, Path.Template.TASK_VIEW);
    };
}