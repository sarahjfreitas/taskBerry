package app;

import spark.*;

public interface IController {
    Route index();
    Route show();
    Route edit();
    Route add();
}