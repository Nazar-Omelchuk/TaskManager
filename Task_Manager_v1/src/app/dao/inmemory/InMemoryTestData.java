package app.dao.inmemory;

import app.model.Task;

import java.util.Arrays;
import java.util.List;

public class InMemoryTestData {

    public static void generateTo(InMemoryDatabase database) {
        database.tasks.clear();

        Task task1 = new Task(1, "Створення макета сторінки створення завдання", 2);
        Task task2 = new Task(2, "Створення макета сторінки редагування завдання", 3);
        Task task3 = new Task(3, "Розробка стилів для елементів інтерфейсу", 4);
        Task task4 = new Task(4, "Розробка бази даних", 1);
        Task task5 = new Task(5, "Налаштування авторизації користувачів", 5);
        Task task6 = new Task(6, "Розробка тестових сценаріїв", 7);
        task2.setCompleted(true);
        List<Task> taskList = Arrays.asList(task1, task2, task3, task4, task5, task6);
        taskList.forEach(task -> database.tasks.put(task.getTaskId(), task));
    }

}
