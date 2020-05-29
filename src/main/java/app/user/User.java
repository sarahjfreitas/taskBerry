package app.user;

import app.AppModel;

import java.time.Instant;

public class User extends AppModel {
    private int userId;
    private String username;
    private String email;
    private String password;
    private String name;
    private boolean active;
    private Instant lastAccess;

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

    public Instant getLastAccess() { return lastAccess; }
    public void setLastAccess(Instant lastAccess) { this.lastAccess = lastAccess; }
    
    public String getActivationDescription(){
        if(active){
            return "Activated";
        }
        else{
            return "Disabled";
        }
    }
}