package app.index;

import app.IController;
import spark.Route;

public class IndexController implements IController {

    public Route index() {
        return null;
    }

    public Route show() { throw new UnsupportedOperationException();}

    public Route edit() {
        throw new UnsupportedOperationException();
    }

    public Route add() {
        throw new UnsupportedOperationException();
    }
}