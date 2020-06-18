package app.issue;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import app.comment.CommentDao;
import app.task.TaskDao;
import app.user.UserDao;

public class IssueTranslator {

	public static List<Issue> translate(List<IssueData> from) {
        List<Issue> issues = new ArrayList<Issue>();
        from.forEach(i -> issues.add(IssueTranslator.translate(i)));
        return issues;
	}

    public static Issue translate(IssueData from) {
        Issue issue = new Issue();
        issue.setIssueId(from.issueId);
        issue.setTask(TaskDao.find(from.taskId));
        issue.setTitle(from.title);
        issue.setCreatedBy(UserDao.find(from.createdBy));
        issue.setCreatedIn(Instant.ofEpochSecond(from.createdIn));
        issue.setComments(CommentDao.findByIssue(from.issueId));

        return issue;
    }
}