package org.example;
import org.example.manager.TaskManager;
import org.example.factory.TaskFactory;
import org.example.factory.PersonalTask;
import org.example.state.PendingState;
import org.example.observer.NotificationService;
import org.example.mediator.TaskMediator;

public class Main {
    public static void main(String[] args) {
        System.out.println("========");

        TaskManager manager = TaskManager.getInstance();    // Singleton

        TaskMediator mediator = new TaskMediator(manager);

        NotificationService notificationService = new NotificationService();    //Observer
        manager.addObserver(notificationService);

        TaskFactory factory = new PersonalTask();
        var task = factory.createTask("Fazer a tarefa do Marco", "aspectos avançados...");

        task.setState(new PendingState());  //initial state

        manager.addTask(task);
        manager.printTasks();

        System.out.println("========");
    }
}