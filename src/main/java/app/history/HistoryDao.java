package app.history;

import app.TaskBerryConnection;
import app.task.Task;
import app.task.TaskData;
import app.task.TaskTranslator;
import org.sql2o.Connection;

import java.util.List;

public class HistoryDao {
    public static void create(HistoryData history) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            String sql = "insert into history(taskId, oldStatus, newStatus, oldResponsible, newResponsible, createdIn,createdBy,description)";
            sql += "VALUES (:taskId, :oldStatus, :newStatus, :oldResponsible, :newResponsible, :createdIn, :createdBy, :description )";
            conn.createQuery(sql)
                .addParameter("taskId", history.taskId)
                .addParameter("oldStatus", history.oldStatus)
                .addParameter("newStatus", history.newStatus)
                .addParameter("oldResponsible", history.oldResponsible)
                .addParameter("newResponsible", history.newResponsible)
                .addParameter("createdIn", history.createdIn)
                .addParameter("createdBy", history.createdBy)
                .addParameter("description", history.description)
                .executeUpdate();
        }
    }

    public static List<History> findByTask(int taskId) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            List<HistoryData> histories = conn.createQuery("select * from history where taskId = :taskId order by historyId DESC")
                .addParameter("taskId",taskId).executeAndFetch(HistoryData.class);
            return HistoryTranslator.translate(histories);
        }
    }
}
