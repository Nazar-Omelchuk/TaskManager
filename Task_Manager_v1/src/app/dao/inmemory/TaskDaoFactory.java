package app.dao.inmemory;

import app.dao.TaskDao;
import app.model.Task;

import java.util.Collection;

public class TaskDaoFactory {

    InMemoryDatabase database;
    TaskDao taskDao;

    public TaskDaoFactory(InMemoryDatabase database) {
        this.database = database;
        taskDao = new InMemoryTaskDao(database);
    }

    public TaskDao getTaskDao() {
        return taskDao;
    }
}
