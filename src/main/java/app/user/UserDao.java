package app.user;

import app.TaskBerryConnection;
import org.sql2o.Connection;
import app.AppDao;
import java.util.List;

public class UserDao extends AppDao {
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

    public static User findByUsername(String username){
        try (Connection conn = TaskBerryConnection.get().open()) {
            UserData user = conn.createQuery("select * from users where username = :username")
                    .addParameter("username",username).executeAndFetchFirst(UserData.class);
            return  UserTranslator.translate(user);
        }
    }

    public static List<UserData> findAll() {
        try (Connection conn = TaskBerryConnection.get().open()) {
            List<UserData> users = conn.createQuery("select * from users")
                    .executeAndFetch(UserData.class);
            return users;
        }
    }

    public static List<UserData> findActives() {
        try (Connection conn = TaskBerryConnection.get().open()) {
            List<UserData> users = conn.createQuery("select * from users where active = 1")
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