package app.services;

import app.dao.inmemory.TaskDaoFactory;
import app.model.Task;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {

    TaskDaoFactory taskDaoFactory;

    public TaskServiceImpl(TaskDaoFactory taskDaoFactory) {
        this.taskDaoFactory = taskDaoFactory;
    }

    @Override
    public Task getTask(int taskId) {
        return taskDaoFactory.getTaskDao().get(taskId);
    }

    @Override
    public Collection<Task> getAllTasks() {
        return taskDaoFactory.getTaskDao().findAll();
    }

    @Override
    public Collection<Task> getSortAllTasks(TaskSortCriteria sortCriteria) {
        if (sortCriteria == TaskSortCriteria.BY_DATE)
            return getAllTasks().stream().sorted(TaskSorters.sorters.get(sortCriteria).reversed())
                    .collect(Collectors.toList());
        return getAllTasks().stream().sorted(TaskSorters.sorters.get(sortCriteria))
                .collect(Collectors.toList());
    }

    @Override
    public void addTask(String text, Integer priority) {
        taskDaoFactory.getTaskDao().add((int)(Math.random() * 99999), text, priority);

    }

    @Override
    public void deleteTask(int taskId) {
        taskDaoFactory.getTaskDao().delete(getTask(taskId));

    }

    @Override
    public void editTask(int taskId, String text, Integer priority) {
        taskDaoFactory.getTaskDao().edit(getTask(taskId), text, priority);
    }

    @Override
    public void completedTask(int taskId) {
        taskDaoFactory.getTaskDao().completed(getTask(taskId));
    }

    @Override
    public String getDate(Task task) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");

        return simpleDateFormat.format(task.getDate());
    }
}
