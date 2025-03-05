package org.example;

import org.example.command.RemoveTaskCommand;
import org.example.command.TaskCommand;
import org.example.factory.TaskFactory;
import org.example.manager.TaskManager;
import org.example.mediator.TaskMediator;
import org.example.state.TaskState;
import org.example.template.Task;
import org.example.chain.ValidationHandler;

public class TaskLogic {
    private final TaskManager manager;
    private final ValidationHandler validator;
    private final TaskMediator mediator;

    public TaskLogic(TaskManager manager, ValidationHandler validator, TaskMediator mediator) {
        this.manager = manager;
        this.validator = validator;
        this.mediator = mediator;
    }

    private boolean isValidTask(Task task) {
        try {
            validator.validate(task);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na validação: " + e.getMessage());
            return false;
        }
    }

    public Task createValidTask(TaskFactory factory, String title, String description) {
        Task task = factory.createTask(title, description);
        return isValidTask(task) ? task : null;
    }

    public void addTask(Task task) {
        mediator.addTaskWithNotification(task);
    }

    public void updateTaskState(Task task, TaskState newState) {
        task.setState(newState);
        task.executeTask();
    }

    public void removeTask(Task task) {
        if (task != null) {
            TaskCommand removeCommand = new RemoveTaskCommand(manager, task);
            removeCommand.execute();
        }
    }

    public void undoRemovedTask(Task task) {
        TaskCommand removeCommand = new RemoveTaskCommand(manager, task);
        removeCommand.undo();
    }
}
