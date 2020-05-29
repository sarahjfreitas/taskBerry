package app.user;

import app.AppController;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static app.util.JsonUtil.dataToJson;

public class UserController extends AppController {
    public static Route index = (Request request, Response response) -> {
        List<User> users = UserTranslator.translate(UserDao.findAll());
        Map<String, Object> model = new HashMap<>();
        model.put("users", users);

        return ViewUtil.render(request, model, Path.Template.USERS);
    };

    public static Route add = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(request, model, Path.Template.USER_ADD);
    };

    public static Route create = (Request request, Response response) -> {
        UserData user = new UserData();
        user.username = request.queryParams("username");
        user.email = request.queryParams("email");
        user.name = request.queryParams("name");
        user.password = request.queryParams("password");
        user.active = 1;
        user.createdIn = Instant.now().getEpochSecond();

        UserDao.create(user);
        response.redirect("/users/");

        return dataToJson(user);
    };

    public static Route edit = (Request request, Response response) -> {
        User user = UserDao.find(Integer.parseInt(request.params(":id")));
        Map<String, Object> model = new HashMap<>();
        model.put("user", user);

        return ViewUtil.render(request, model, Path.Template.USER_EDIT);
    };

    public static Route update = (Request request, Response response) -> {
        User user = UserDao.find(Integer.parseInt(request.params(":id")));

        user.setUsername(request.queryParams("username"));
        user.setEmail(request.queryParams("email"));
        user.setName(request.queryParams("name"));
        user.setPassword(request.queryParams("password"));
        user.setUpdatedIn(Instant.now());
        UserDao.update(UserTranslator.translate(user));
        response.redirect("/users/");

        return dataToJson(user);
    };

    public static Route delete = (Request request, Response response) -> {
        User user = UserDao.find(Integer.parseInt(request.params(":id")));
        user.deactivate();
        user.setDisabledIn(Instant.now());
        UserDao.update(UserTranslator.translate(user));
        response.redirect("/users/");

        return dataToJson(user);
    };
}
