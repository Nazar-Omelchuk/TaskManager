package app.dao.inmemory;

import app.model.Task;

import java.util.*;

public class InMemoryDatabase {

    Map<Integer, Task> tasks;

    public InMemoryDatabase() {
        this.tasks = new TreeMap<>();
    }

    public TaskDaoFactory getDaoFactory() {
        return new TaskDaoFactory(this);
    }

}
