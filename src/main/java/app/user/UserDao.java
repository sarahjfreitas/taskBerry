package app.user;

import app.TaskBerryConnection;
import app.project.Project;
import app.project.ProjectData;
import app.project.ProjectTranslator;
import app.task.TaskData;
import app.task.TaskTranslator;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Sql2o sql2o;

    public static UserData findData(int userId){
        try (Connection conn = TaskBerryConnection.get().open()) {
            UserData user = conn.createQuery("select * from users where userId = :userId")
                    .addParameter("userId",userId).executeAndFetchFirst(UserData.class);
            return user;
        }
    }

    public static User find(int userId){
        return UserTranslator.translate(findData(userId));
    }

    public static List<UserData> findAll() {
        try (Connection conn = TaskBerryConnection.get().open()) {
            List<UserData> users = conn.createQuery("select * from users")
                    .executeAndFetch(UserData.class);
            return users;
        }
    }

    public static void create(UserData user) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            String sql = "insert into users(name, username, email, password, active, createdIn)";
            sql += "VALUES (:name, :username, :email, :password, :active, :createdIn)";
            conn.createQuery(sql)
                    .addParameter("name", user.name)
                    .addParameter("username", user.username)
                    .addParameter("email", user.email)
                    .addParameter("password", user.password)
                    .addParameter("active", user.active)
                    .addParameter("createdIn", user.createdIn)
                    .executeUpdate();
        }
    }

    public static void update(UserData user) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            String sql = "update users set name = :name, username = :username, email = :email";
            sql += ", password = :password, active = :active, updatedIn = :updatedIn, disabledIn = :disabledIn";
            sql += " where userId = :userId";

            conn.createQuery(sql)
                    .addParameter("name", user.name)
                    .addParameter("username", user.username)
                    .addParameter("email", user.email)
                    .addParameter("password", user.password)
                    .addParameter("active", user.active)
                    .addParameter("updatedIn", user.updatedIn)
                    .addParameter("disabledIn", user.disabledIn)
                    .addParameter("userId", user.userId)
                    .executeUpdate();
        }
    }
}