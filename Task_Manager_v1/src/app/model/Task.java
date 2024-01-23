package app.model;

import java.util.*;

public class Task implements Comparable<Task> {

    private int taskId;
    private String text;
    private Date date;
    private Integer priority;
    private boolean isCompleted;

    public Task(int taskId, String text, int priority) {
        this.taskId = taskId;
        this.text = text;
        this.date = new Date();
        this.priority = priority;
        this.isCompleted = false;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text.equals("")) {
            throw new IllegalArgumentException("Text of task can't be empty! ");
        }
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        if (priority <= 0) {
            throw new IllegalArgumentException("Priority must be > 0");
        }
        this.priority = priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public int compareTo(Task task) {
        return this.priority.compareTo(task.getPriority());
    }

    public int getTaskId() {
        return taskId;
    }
}