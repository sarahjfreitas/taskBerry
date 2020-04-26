package app.comment;

import app.task.Task;
import app.user.User;

import java.time.LocalDate;

public class Comment {
    private int commentId;
    private String content;
    private Task task;
    private User author;
    private LocalDate createdIn;
    private LocalDate updatedIn;

    public int getCommentId() { return commentId; }
    public void setCommentId(int commentId) { this.commentId = commentId; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Task getTask() { return task; }
    public void setTask(Task task) { this.task = task; }

    public User getAuthor() { return author; }
    public void setAuthor(User author) { this.author = author; }

    public LocalDate getCreatedIn() { return createdIn; }
    public void setCreatedIn(LocalDate createdIn) { this.createdIn = createdIn; }

    public LocalDate getUpdatedIn() { return updatedIn;  }
    public void setUpdatedIn(LocalDate updatedIn) { this.updatedIn = updatedIn; }
}