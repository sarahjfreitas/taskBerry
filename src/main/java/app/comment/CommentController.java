package app.comment;

import app.AppController;
import app.login.LoginController;
import app.user.UserController;
import spark.Request;
import spark.Response;
import spark.Route;

import java.time.Instant;

import static app.util.JsonUtil.dataToJson;

public class CommentController extends AppController {
    public static Route create = (Request request, Response response) -> {
        CommentData commentData = new CommentData();
        commentData.content = request.queryParams("content");
        commentData.createdIn = Instant.now().getEpochSecond();
        commentData.createdBy = LoginController.getUser().getUserId();
        commentData.taskId = Integer.parseInt(request.queryParams("taskId"));
        CommentDao.create(commentData);

        response.redirect("/tasks/view/"+request.queryParams("taskId")+"/");
        return dataToJson(commentData);
    };
}