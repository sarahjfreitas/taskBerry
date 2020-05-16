package app.task;

import app.AppModel;
import app.comment.Comment;
import app.project.Project;
import app.user.User;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task extends AppModel {
    private int taskId;
    private String name;
    private String description;
    private Status currentStatus;
    private User responsible;
    private List<Comment> comments;
    private Project project;

    public int getTaskId() { return taskId; }
    public void setTaskId(int taskId) { this.taskId = taskId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Status getCurrentStatus() { return currentStatus; }
    public void setCurrentStatus(Status currentStatus) { this.currentStatus = currentStatus; }

    public User getResponsible() { return responsible; }
    public void setResponsible(User responsible) { this.responsible = responsible; }

    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
}