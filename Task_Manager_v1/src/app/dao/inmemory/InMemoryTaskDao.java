package app.dao.inmemory;

import app.dao.TaskDao;
import app.model.Task;

import java.util.Collection;

public class InMemoryTaskDao implements TaskDao {

    protected InMemoryDatabase database;

    public InMemoryTaskDao(InMemoryDatabase database) {
        this.database = database;
    }

    @Override
    public void completed(Task task) {
        task.setCompleted(true);
    }

    @Override
    public void add(int taskId, String text, Integer priority) {
        Task task = new Task(taskId, text, priority);
        database.tasks.put(task.getTaskId(), task);
    }

    @Override
    public void delete(Integer taskId) {
        database.tasks.remove(taskId);
    }

    @Override
    public Task get(int id) {
        return database.tasks.get(id);
    }

    @Override
    public Collection<Task> findAll() {
        return database.tasks.values();
    }

    @Override
    public void insert(Task entity) {
        database.tasks.put(entity.getTaskId(), entity);
    }

    @Override
    public void delete(Task entity) {
        database.tasks.remove(entity.getTaskId());

    }

    @Override
    public void edit(Task task, String text, Integer priority) {
        task.setPriority(priority);
        task.setText(text);
    }

    @Override
    public void update(Task entity) {
        database.tasks.put(entity.getTaskId(), entity);
    }
}

