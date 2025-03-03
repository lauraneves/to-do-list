package org.example.mediator;
import org.example.manager.TaskManager;
import org.example.observer.NotificationService;
import org.example.template.Task;

public class TaskMediator {
    private TaskManager taskManager;
    private NotificationService notificationService;

    public TaskMediator(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.notificationService = new NotificationService();
        taskManager.addObserver(notificationService);
    }


}
