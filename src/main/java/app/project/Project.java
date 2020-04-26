package app.project;

import app.task.Task;
import app.user.User;

import java.time.LocalDate;
import java.util.List;

public class Project {
    private int projectId;
    private String name;
    private boolean active;
    private List<Task> tasks;
    private LocalDate createdIn;
    private LocalDate updatedIn;
    private LocalDate deactivateIn;
    private User createdBy;
    private User updatedBy;
    private User deactivateBy;

    public int getProjectId() { return projectId; }
    public void setProjectId(int projectId) { this.projectId = projectId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isActive() { return active; }
    public void activate() { this.active = true; }
    public void deactivate() { this.active = false; }

    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }

    public LocalDate getCreatedIn() { return createdIn; }
    public void setCreatedIn(LocalDate createdIn) { this.createdIn = createdIn; }

    public LocalDate getUpdatedIn() { return updatedIn;}
    public void setUpdatedIn(LocalDate updatedIn) { this.updatedIn = updatedIn; }

    public LocalDate getDeactivateIn() { return deactivateIn; }
    public void setDeactivateIn(LocalDate deactivateIn) { this.deactivateIn = deactivateIn; }

    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }

    public User getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(User updatedBy) { this.updatedBy = updatedBy; }

    public User getDeactivateBy() { return deactivateBy; }
    public void setDeactivateBy(User deactivateBy) { this.deactivateBy = deactivateBy; }
}