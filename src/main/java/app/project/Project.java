package app.project;

import app.task.Task;
import app.user.User;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Project {
    private int projectId;
    private String name;
    private boolean active;
    private List<Task> tasks;
    private Instant createdIn;
    private Instant updatedIn;
    private Instant disabledIn;
    private User createdBy;
    private User updatedBy;
    private User disabledBy;

    public int getProjectId() { return projectId; }
    public void setProjectId(int projectId) { this.projectId = projectId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isActive() { return active; }
    public void activate() { this.active = true; }
    public void deactivate() { this.active = false; }

    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }

    public Instant getCreatedIn() { return createdIn; }
    public void setCreatedIn(Instant createdIn) { this.createdIn = createdIn; }

    public Instant getUpdatedIn() { return updatedIn;}
    public void setUpdatedIn(Instant updatedIn) { this.updatedIn = updatedIn; }

    public Instant getDisabledIn() { return disabledIn; }
    public void setDisabledIn(Instant disabledIn) { this.disabledIn = disabledIn; }

    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }

    public User getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(User updatedBy) { this.updatedBy = updatedBy; }

    public User getDisabledBy() { return disabledBy; }
    public void setDisabledBy(User disabledBy) { this.disabledBy = disabledBy; }

    public String getActivationDescription() {
        if(isActive()){
            return "Activated";
        }
        return "Deactivated";
    }

    public String getFormatedCreatedIn(){
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
        return DATE_TIME_FORMATTER.format(createdIn);
    }
}