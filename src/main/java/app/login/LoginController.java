package app.login;

import app.user.User;
import app.user.UserDao;

public class LoginController {
    //TODO: CHANGE TO LOGGED USER

    public static User getUser(){
        return UserDao.find(1);
    }
}