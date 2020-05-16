package app.project;

import app.AppModel;
import app.task.Task;
import app.user.User;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Project extends AppModel {
    private int projectId;
    private String name;
    private boolean active;
    private List<Task> tasks;
    private Instant disabledIn;
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

    public Instant getDisabledIn() { return disabledIn; }
    public void setDisabledIn(Instant disabledIn) { this.disabledIn = disabledIn; }

    public User getDisabledBy() { return disabledBy; }
    public void setDisabledBy(User disabledBy) { this.disabledBy = disabledBy; }

    public String getActivationDescription() {
        if(isActive()){
            return "Activated";
        }
        return "Deactivated";
    }
}