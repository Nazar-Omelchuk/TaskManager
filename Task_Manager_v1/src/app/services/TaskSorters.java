package app.services;

import app.model.Task;
import java.util.*;

public class TaskSorters {

    public static final Map<TaskSortCriteria, Comparator<Task>> sorters;

    static {
        sorters = new HashMap<>();
        sorters.put(TaskSortCriteria.BY_PRIORITY, Comparator.comparing(Task::getPriority));
        sorters.put(TaskSortCriteria.BY_DATE, Comparator.comparing(Task::getDate));
    }

}
