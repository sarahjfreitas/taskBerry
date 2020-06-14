package app.login;

import app.AppController;
import app.user.User;
import app.user.UserDao;

public class LoginController extends AppController {
    //TODO: CHANGE TO LOGGED USER

    public static User getUser(){
        return UserDao.find(1);
    }
}