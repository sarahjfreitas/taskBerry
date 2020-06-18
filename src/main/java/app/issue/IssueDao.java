package app.issue;

import app.AppDao;
import app.TaskBerryConnection;
import java.util.List;
import org.sql2o.Connection;

public class IssueDao extends AppDao {
    public static void create(IssueData issue) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            String sql = "insert into issues(title, createdIn, createdBy, taskId)";
            sql += "VALUES (:title, :createdIn, :createdBy, :taskId)";
            conn.createQuery(sql)
                    .addParameter("title", issue.title)
                    .addParameter("createdIn", issue.createdIn)
                    .addParameter("createdBy", issue.createdBy)
                    .addParameter("taskId", issue.taskId)
                    .executeUpdate();
        }
    }

    public static List<Issue> findByTask(int taskId) {
        try (Connection conn = TaskBerryConnection.get().open()) {
            List<IssueData> issues = conn.createQuery("select * from issues where taskId = :taskId order by issueId DESC")
                    .addParameter("taskId",taskId).executeAndFetch(IssueData.class);
            return IssueTranslator.translate(issues);
        }
    }

	public static Issue find(int issueId) {
		try (Connection conn = TaskBerryConnection.get().open()) {
            IssueData issue = conn.createQuery("select * from issues where issueId = :issueId").addParameter("issueId",issueId).executeAndFetchFirst(IssueData.class);
            return IssueTranslator.translate(issue);
        }
    }
}