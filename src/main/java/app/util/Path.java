package app.util;

import lombok.*;

public class Path {
    // Views paths
    public static class Template {
        public static final String NOT_FOUND = "/views/notFound.vm";
        public final static String INDEX = "/views/index/index.vm";
        public final static String PROJECTS = "/views/project/index.vm";
        public final static String PROJECT_ADD = "/views/project/new.vm";
        public final static String PROJECT_EDIT = "/views/project/edit.vm";
        public final static String TASKS = "/views/task/index.vm";
        public final static String TASK_ADD = "/views/task/new.vm";
        public final static String TASK_EDIT = "/views/task/edit.vm";
        public final static String TASK_VIEW = "/views/task/view.vm";
        public final static String ISSUE_VIEW = "/views/issue/view.vm";
        public final static String USERS = "/views/user/index.vm";
        public final static String USER_ADD = "/views/user/new.vm";
        public final static String USER_EDIT = "/views/user/edit.vm";
        public final static String USER_VIEW = "/views/user/view.vm";
    }
}