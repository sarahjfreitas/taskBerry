package app.comment;

import app.AppDao;
import app.TaskBerryConnection;
import org.sql2o.Connection;

import java.util.List;

public class CommentDao extends AppDao {
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
            List<CommentData> comments = conn.createQuery("select * from comments where taskId = :taskId and parentId is NULL order by commentId DESC")
                    .addParameter("taskId",taskId).executeAndFetch(CommentData.class);
            return CommentTranslator.translate(comments);
        }
    }

    public static List<Comment> findChildren(int commentId) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            List<CommentData> comments = conn.createQuery("select * from comments where parentId = :parentId order by commentId DESC")
                    .addParameter("parentId",commentId).executeAndFetch(CommentData.class);
            return CommentTranslator.translate(comments);
        }
    }
}