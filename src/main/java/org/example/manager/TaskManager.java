package org.example.manager;

import org.example.observer.Observer;
import org.example.template.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static TaskManager instance;
    private final List<Task> tasks;
    private final List<Observer> observers;

    private TaskManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers("Nova tarefa adicionada: " + task.getTitle());
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        notifyObservers("Tarefa removida: " + task.getTitle());
    }

    public void printTasks() {
        System.out.println("Lista de Tarefas:");
        for (Task task : tasks) {
            System.out.println("- " + task.getTitle() + " (" + task.getState().getClass().getSimpleName() + ")");
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
