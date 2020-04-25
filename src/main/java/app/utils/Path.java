package app.utils;

        import lombok.*;

public class Path {
    // The @Getter methods are needed in order to access
    // the variables from Velocity Templates
    public static class Web {
        @Getter public static final String INDEX = "/";
        @Getter public static final String LOGIN = "/login/";
        @Getter public static final String LOGOUT = "/logout/";
        @Getter public static final String TASKS = "/task/";
        @Getter public static final String TASK = "/task/:id/";
    }
}