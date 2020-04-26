package app.user;

import java.time.LocalDate;

public class User {
    private int userId;
    private String username;
    private String email;
    private String password;
    private String name;
    private boolean active;
    private LocalDate createIn;
    private LocalDate lastAccess;
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

    public LocalDate getCreateIn() { return createIn; }
    public void setCreateIn(LocalDate createIn) { this.createIn = createIn; }

    public LocalDate getLastAccess() { return lastAccess; }
    public void setLastAccess(LocalDate lastAccess) { this.lastAccess = lastAccess; }

    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }
}