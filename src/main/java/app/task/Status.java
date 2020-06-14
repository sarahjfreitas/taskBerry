package app.task;

import app.TaskBerryConnection;
import app.comment.CommentDao;

public enum Status extends TaskBerryConnection {
    PENDING,
    WAITING_INPUT,
    IN_PROGRESS,
    READY_TO_TEST,
    DONE,
}