package app;

import app.user.User;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class AppModel {
    protected Instant createdIn;
    protected Instant updatedIn;
    protected Instant disabledIn;
    protected User createdBy;
    protected User updatedBy;
    protected User disabledBy;

    public Instant getCreatedIn() {
        return createdIn;
    }
    public void setCreatedIn(Instant createdIn) {
        this.createdIn = createdIn;
    }
    public String getFormattedCreatedIn() { return formatInstant(createdIn); }

    public Instant getUpdatedIn() {
        return updatedIn;
    }
    public void setUpdatedIn(Instant updatedIn) {
        this.updatedIn = updatedIn;
    }
    public String getFormattedUpdatedIn() { return formatInstant(updatedIn); }

    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }

    public User getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(User updatedBy) { this.updatedBy = updatedBy; }

    public Instant getDisabledIn() {
        return disabledIn;
    }
    public void setDisabledIn(Instant disabledIn) { this.disabledIn = disabledIn;}
    public String getFormattedDisabledIn() { return formatInstant(disabledIn); };

    public User getDisabledBy() { return disabledBy; }
    public void setDisabledBy(User disabledBy) { this.disabledBy = disabledBy; }

    private String formatInstant(Instant instant) {
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
        return DATE_TIME_FORMATTER.format(instant);
    }
}