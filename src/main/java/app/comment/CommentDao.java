package app.comment;

import app.TaskBerryConnection;
import org.sql2o.Connection;

import java.util.List;

public class CommentDao {
    public static void create(CommentData comment) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            String sql = "insert into comments(content, createdIn, createdBy, taskId)";
            sql += "VALUES (:content, :createdIn, :createdBy, :taskId)";
            conn.createQuery(sql)
                    .addParameter("content", comment.content)
                    .addParameter("createdIn", comment.createdIn)
                    .addParameter("createdBy", comment.createdBy)
                    .addParameter("taskId", comment.taskId)
                    .executeUpdate();
        }
    }

    public static List<Comment> findByTask(int taskId) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            List<CommentData> comments = conn.createQuery("select * from comments where taskId = :taskId order by commentId DESC")
                    .addParameter("taskId",taskId).executeAndFetch(CommentData.class);
            return CommentTranslator.translate(comments);
        }
    }
}
