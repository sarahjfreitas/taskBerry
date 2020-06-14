package app.history;

import app.AppData;

public class HistoryData extends AppData {
    public int historyId;
    public int taskId;
    public String oldStatus;
    public String newStatus;
    public int oldResponsible;
    public int newResponsible;
    public int createdBy;
    public String description;
}