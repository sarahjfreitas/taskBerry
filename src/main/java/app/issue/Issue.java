package app.issue;

import java.util.List;
import app.AppModel;
import app.task.Task;
import app.comment.Comment;

public class Issue extends AppModel {
    private int issueId;
    private Task task;
    private String title;
    private List<Comment> comments;

    public int getIssueId() {
        return issueId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
}