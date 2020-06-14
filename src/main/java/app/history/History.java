package app.history;

import app.AppModel;
import app.task.Status;
import app.user.User;

import java.time.Instant;

public class History extends AppModel {
    private int historyId;
    private int taskId;
    private Status oldStatus;
    private Status newStatus;
    private User oldResponsible;
    private User newResponsible;
    private String description;

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Status getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Status oldStatus) {
        this.oldStatus = oldStatus;
    }

    public Status getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Status newStatus) {
        this.newStatus = newStatus;
    }

    public User getOldResponsible() {
        return oldResponsible;
    }

    public void setOldResponsible(User oldResponsible) {
        this.oldResponsible = oldResponsible;
    }

    public User getNewResponsible() {
        return newResponsible;
    }

    public void setNewResponsible(User newResponsible) {
        this.newResponsible = newResponsible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
