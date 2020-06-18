package app.issue;

import java.time.Instant;
import app.AppController;
import app.login.LoginController;
import spark.Request;
import spark.Response;
import spark.Route;
import static app.util.JsonUtil.dataToJson;

public class IssueController extends AppController {
    public static Route create = (Request request, Response response) -> {
        IssueData issueData = new IssueData();
        issueData.title = request.queryParams("title");
        issueData.createdIn = Instant.now().getEpochSecond();
        issueData.createdBy = LoginController.getUser().getUserId();
        issueData.taskId = Integer.parseInt(request.queryParams("taskId"));
        IssueDao.create(issueData);

        response.redirect("/tasks/view/"+request.queryParams("taskId")+"/");
        return dataToJson(issueData);
    };  
}