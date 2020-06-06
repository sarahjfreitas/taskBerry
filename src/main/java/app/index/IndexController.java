package app.index;

import app.login.LoginController;
import app.task.Status;
import app.task.Task;
import app.task.TaskDao;
import app.user.User;
import app.util.*;
import spark.*;
import java.util.*;

public class IndexController {
    public static Route index = (Request request, Response response) -> {
        User user = LoginController.getUser();
        List<Task> pendingTasks = TaskDao.findByUserAndStatus(user.getUserId(), Status.PENDING.name());
        List<Task> progressTasks = TaskDao.findByUserAndStatus(user.getUserId(), Status.IN_PROGRESS.name());
        List<Task> testingTasks = TaskDao.findByUserAndStatus(user.getUserId(), Status.READY_TO_TEST.name());

        Map<String, Object> model = new HashMap<>();
        model.put("pendingTasks", pendingTasks);
        model.put("progressTasks", progressTasks);
        model.put("testingTasks", testingTasks);

        return ViewUtil.render(request, model, Path.Template.INDEX);
    };
}