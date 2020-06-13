package app.history;

import app.task.Status;
import app.task.Task;
import app.user.UserDao;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class HistoryTranslator {
    public static List<History> translate(List<HistoryData> from) {
        List<History> histories = new ArrayList<History>();
        from.forEach(f -> histories.add(translate(f)));

        return histories;
    }

    private static History translate(HistoryData from) {
        History history = new History();
        history.setHistoryId(from.historyId);
        history.setTaskId(from.taskId);
        history.setOldStatus(Status.valueOf(from.oldStatus));
        history.setNewStatus(Status.valueOf(from.newStatus));
        history.setOldResponsible(UserDao.find(from.oldResponsible));
        history.setNewResponsible(UserDao.find(from.newResponsible));
        history.setCreatedIn(Instant.ofEpochSecond(from.createdIn));
        history.setCreatedBy(UserDao.find(from.createdBy));
        history.setDescription(from.description);

        return history;
    }
}
