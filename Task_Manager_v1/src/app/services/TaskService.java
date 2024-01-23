package app.services;

import app.model.Task;

import java.util.*;

public interface TaskService {

    Task getTask(int taskId);

    Collection<Task> getAllTasks();

    Collection<Task> getSortAllTasks (TaskSortCriteria sortCriteria);

    void addTask(String text, Integer priority);

    void deleteTask(int taskId);

    void editTask(int taskId, String text, Integer priority);

    void completedTask(int taskId);

    String getDate(Task task);
}
