package app.comment;

import app.AppModel;
import app.task.Task;
import app.user.User;

import java.time.LocalDate;

public class Comment extends AppModel {
    private int commentId;
    private String content;
    private Task task;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}