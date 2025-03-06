package org.example.manager;

import org.example.observer.Observer;
import org.example.template.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static TaskManager instance;
    private final List<Task> tasks = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    private TaskManager() {}

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Adicionando tarefa: " + task.getTitle());
        notifyObservers("Nova tarefa adicionada: " + task.getTitle());
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        System.out.println("Removendo tarefa: " + task.getTitle());
        notifyObservers("Tarefa removida: " + task.getTitle());
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void printTasks() {
        System.out.println("Lista de Tarefas:");
        for (Task task : tasks) {
            System.out.println("- " + task.getTitle() + " [" + task.getCategory() + "] (" + task.getState().getClass().getSimpleName() + ")");
        }
    }
}
