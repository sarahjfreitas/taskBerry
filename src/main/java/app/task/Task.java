package app.task;

import app.comment.Comment;
import app.project.Project;
import app.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private int taskId;
    private String name;
    private String description;
    private Status currentStatus;
    private User responsible;
    private List<Comment> comments;
    private LocalDate createdIn;
    private LocalDate updatedIn;
    private Project project;

    public Task() {
    }

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

    public LocalDate getCreatedIn() { return createdIn; }
    public void setCreatedIn(LocalDate createdIn) { this.createdIn = createdIn; }

    public LocalDate getUpdatedIn() { return updatedIn; }
    public void setUpdatedIn(LocalDate updated_in) {this.updatedIn = updated_in; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
}