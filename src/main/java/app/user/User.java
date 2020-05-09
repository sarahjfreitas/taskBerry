package app.user;

import java.time.Instant;
import java.time.LocalDate;

public class User {
    private int userId;
    private String username;
    private String email;
    private String password;
    private String name;
    private boolean active;
    private Instant createdIn;
    private Instant updatedIn;
    private Instant disabledIn;
    private Instant lastAccess;
    private User createdBy;

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isActive() { return active; }
    public void activate() { this.active = true; }
    public void deactivate() { this.active = false; }

    public Instant getCreateIn() { return createdIn; }
    public void setCreateIn(Instant createdIn) { this.createdIn = createdIn; }

    public Instant getUpdatedIn() { return updatedIn;}
    public void setUpdatedIn(Instant updatedIn) { this.updatedIn = updatedIn; }

    public Instant getDisabledIn() { return disabledIn; }
    public void setDisabledIn(Instant disabledIn) { this.disabledIn = disabledIn; }

    public Instant getLastAccess() { return lastAccess; }
    public void setLastAccess(Instant lastAccess) { this.lastAccess = lastAccess; }

    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }
}