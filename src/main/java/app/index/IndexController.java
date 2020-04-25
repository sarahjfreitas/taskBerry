package app.index;

import spark.*;
import java.util.*;

import app.util.*;

public class IndexController {
    public static Route index = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        return ViewUtil.render(request, model, Path.Template.INDEX);
    };
}