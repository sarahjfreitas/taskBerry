package app.user;

import app.TaskBerryConnection;
import app.project.Project;
import app.project.ProjectData;
import app.project.ProjectTranslator;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Sql2o sql2o;

    // TODO: CHANGE TO FIND IN DB
    public static User find(int userId){
        User user = new User();
        user.setUserId(userId);
        user.setName("admin");
        user.setEmail("admin@admin.com");
        return user;
    }

    // TODO: CHANGE TO FIND IN DB
    public static List<User> findAll() {
        List<User> users = new ArrayList<User>();
        users.add(find(1));
        return users;
    }

}
