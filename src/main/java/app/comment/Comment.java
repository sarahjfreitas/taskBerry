package app.comment;

import app.AppModel;
import app.task.Task;
import app.user.User;

import java.time.LocalDate;
import java.util.List;

public class Comment extends AppModel {
    private int commentId;
    private String content;
    private Task task;
    private List<Comment> children;

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

    public List<Comment> getChildren(){
        return children;
    }

    public void setChildren(List<Comment> children){
        this.children = children;
    }
}