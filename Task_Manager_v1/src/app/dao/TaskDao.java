package app.dao;

import app.model.Task;

public interface TaskDao extends AbstractDao<Task> {

    void completed(Task task);

    void add (int taskId, String text, Integer priority);

    void delete (Integer taskId);

    void edit (Task task, String text, Integer priority);
}
