package app.task;

import app.project.Project;
import app.project.ProjectDao;
import app.user.UserDao;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TaskTranslator {
    public static Task translate(TaskData from){
        Task task = new Task();
        task.setTaskId(from.taskId);
        task.setName(from.name);
        task.setDescription(from.description);
        task.setCurrentStatus(Status.valueOf(from.currentStatus));
        task.setResponsible(UserDao.find(from.responsible));
        task.setCreatedIn(Instant.ofEpochSecond(from.createdIn));
        task.setUpdatedIn(Instant.ofEpochSecond(from.updatedIn));
        task.setProject(ProjectDao.find(from.projectId));

        return task;
    }

    public static TaskData translate(Task from){
        TaskData taskData = new TaskData();
        taskData.taskId = from.getTaskId();
        taskData.name = from.getName();
        taskData.description = from.getDescription();
        taskData.currentStatus = from.getCurrentStatus().name();
        taskData.responsible = from.getResponsible().getUserId();
        taskData.createdIn = from.getCreatedIn().getEpochSecond();
        if(from.getUpdatedIn() != null)
            taskData.updatedIn = from.getUpdatedIn().getEpochSecond();
        taskData.projectId = from.getProject().getProjectId();

        return  taskData;
    }

    public static List<Task> translate (List<TaskData> from){
        List<Task> tasks = new ArrayList<Task>();
        from.forEach(f -> tasks.add(translate(f)));

        return tasks;
    }
}
