package app.issue;

import java.time.Instant;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.AppController;
import app.history.History;
import app.history.HistoryDao;
import app.login.LoginController;
import app.task.Status;
import app.task.Task;
import app.task.TaskDao;
import app.user.User;
import app.user.UserDao;
import app.user.UserTranslator;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
import static app.util.JsonUtil.dataToJson;

public class IssueController extends AppController {
    public static Route create = (Request request, Response response) -> {
        IssueData issueData = new IssueData();
        issueData.title = request.queryParams("title");
        issueData.createdIn = Instant.now().getEpochSecond();
        issueData.createdBy = LoginController.getUser(request).getUserId();
        issueData.taskId = Integer.parseInt(request.queryParams("taskId"));
        IssueDao.create(issueData);

        response.redirect("/tasks/view/"+request.queryParams("taskId")+"/");
        return dataToJson(issueData);
    };

    public static Route view = (Request request, Response response) -> {
        Issue issue = IssueDao.find(Integer.parseInt(request.params(":id")));
        Map<String, Object> model = new HashMap<>();
        model.put("issue", issue);

        return ViewUtil.render(request, model, Path.Template.ISSUE_VIEW);
    };
}