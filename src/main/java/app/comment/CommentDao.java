package app.comment;

import app.AppDao;
import app.TaskBerryConnection;
import org.sql2o.Connection;

import java.util.List;

public class CommentDao extends AppDao {
    public static void create(CommentData comment) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            String sql = "insert into comments(content, createdIn, createdBy, issueId)";
            sql += "VALUES (:content, :createdIn, :createdBy, :issueId)";
            conn.createQuery(sql)
                    .addParameter("content", comment.content)
                    .addParameter("createdIn", comment.createdIn)
                    .addParameter("createdBy", comment.createdBy)
                    .addParameter("issueId", comment.issueId)
                    .executeUpdate();
        }
    }

    public static List<Comment> findByIssue(int issueId) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            List<CommentData> comments = conn.createQuery("select * from comments where issueId = :issueId order by commentId DESC")
                    .addParameter("issueId",issueId).executeAndFetch(CommentData.class);
            return CommentTranslator.translate(comments);
        }
    }
}