package org.example.mediator;
import org.example.manager.TaskManager;
import org.example.observer.NotificationService;
import org.example.template.Task;

public class TaskMediator {
    private final TaskManager taskManager;
    private final NotificationService notificationService;

    public TaskMediator(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.notificationService = new NotificationService();
        taskManager.addObserver(notificationService);
    }

    public void addTaskWithNotification(Task task) {
        taskManager.addTask(task);
        notificationService.update("Tarefa mediada adicionada: " + task.getTitle());
    }
}
