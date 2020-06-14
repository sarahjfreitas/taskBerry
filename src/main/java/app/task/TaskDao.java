package app.task;

import app.TaskBerryConnection;
import app.AppDao;
import org.sql2o.Connection;
import java.util.List;

public class TaskDao extends AppDao {
    public static void create(TaskData task) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            String sql = "insert into tasks(name, description, currentStatus, responsible, createdIn, projectId)";
            sql += "VALUES (:name, :description, :currentStatus, :responsible, :createdIn, :projectId)";
            conn.createQuery(sql)
                    .addParameter("name", task.name)
                    .addParameter("description", task.description)
                    .addParameter("currentStatus", task.currentStatus)
                    .addParameter("responsible", task.responsible)
                    .addParameter("createdIn", task.createdIn)
                    .addParameter("projectId", task.projectId)
                    .executeUpdate();
        }
    }

    public static void update(TaskData task) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            String sql = "update tasks set name = :name, description = :description, currentStatus = :currentStatus";
            sql += ", responsible = :responsible, updatedIn = :updatedIn";
            sql += " where taskId = :taskId";

            conn.createQuery(sql)
                    .addParameter("name", task.name)
                    .addParameter("description", task.description)
                    .addParameter("currentStatus", task.currentStatus)
                    .addParameter("responsible", task.responsible)
                    .addParameter("updatedIn", task.updatedIn)
                    .addParameter("taskId", task.taskId)
                    .executeUpdate();
        }
    }

    public static void delete(int taskId) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            conn.createQuery("delete from tasks where taskId = :taskId").addParameter("taskId",taskId).executeUpdate();
        }
    }

    public static Task find(int taskId){
        try (Connection conn = TaskBerryConnection.get().open()) {
            TaskData task = conn.createQuery("select * from tasks where taskId = :taskId").addParameter("taskId",taskId).executeAndFetchFirst(TaskData.class);
            return TaskTranslator.translate(task);
        }
    }

    public static List<Task> findAll() {
        try (Connection conn = TaskBerryConnection.get().open()) {
            List<TaskData> tasks = conn.createQuery("select * from tasks").executeAndFetch(TaskData.class);
            return TaskTranslator.translate(tasks);
        }
    }

    public static List<Task> findByProject(int projectId) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            List<TaskData> tasks = conn.createQuery("select * from tasks where projectId = :projectId").addParameter("projectId",projectId).executeAndFetch(TaskData.class);
            return TaskTranslator.translate(tasks);
        }
    }

    public static List<Task> findByUserAndStatus(int userId,String currentStatus) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            String sql = "select * from tasks where responsible = :userId and currentStatus = :currentStatus";
            List<TaskData> tasks = conn.createQuery(sql)
                    .addParameter("userId",userId)
                    .addParameter("currentStatus",currentStatus)
                    .executeAndFetch(TaskData.class);

            return TaskTranslator.translate(tasks);
        }
    }
}
