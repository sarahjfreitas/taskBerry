package app.login;

import java.util.*;
import spark.*;
import app.AppController;
import app.user.*;
import app.util.*;

public class LoginController extends AppController {
    public static Route index = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();

        return ViewUtil.render(request, model, Path.Template.LOGIN);
    };

    public static User getUser(Request request) {
        return UserDao.findByUsername(request.session().attribute("currentUser"));
    }

    public static Route login = (Request request, Response response) -> {        
        String username = request.queryParams("username");
        String password = request.queryParams("password");

        if (!User.authenticate(username, password)) {
            Map<String, Object> model = new HashMap<>();
            model.put("authenticationFailed", true);
            return ViewUtil.render(request, model, Path.Template.LOGIN);
        }

        request.session().attribute("currentUser", username);

        if (request.session().attribute("loginRedirect") != null) {
            response.redirect(request.session().attribute("loginRedirect"));
        }

        response.redirect("/");
        return null;    
    };

    public static Route logout = (Request request, Response response) -> {
        request.session().removeAttribute("currentUser");
        response.redirect("/login/");
        return null;
    };
}