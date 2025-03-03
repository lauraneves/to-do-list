package org.example;
import org.example.manager.TaskManager;
import org.example.observer.NotificationService;
import org.example.mediator.TaskMediator;

public class Main {
    public static void main(String[] args) {
        System.out.println("==== começa ====");

        TaskManager manager = TaskManager.getInstance();

        TaskMediator mediator = new TaskMediator(manager);

        NotificationService notificationService = new NotificationService();
        manager.addObserver(notificationService);


    }
}