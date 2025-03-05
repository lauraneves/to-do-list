package org.example;

import org.example.command.AddTaskCommand;
import org.example.command.RemoveTaskCommand;
import org.example.command.TaskCommand;
import org.example.factory.TaskFactory;
import org.example.manager.TaskManager;
import org.example.state.TaskState;
import org.example.template.Task;
import org.example.chain.ValidationHandler;

public class TaskLogic {
    private final TaskManager manager;
    private final ValidationHandler validator;

    public TaskLogic(TaskManager manager, ValidationHandler validator) {
        this.manager = manager;
        this.validator = validator;
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
        if (task != null) {
            TaskCommand addCommand = new AddTaskCommand(manager, task);
            addCommand.execute();
        }
    }

    public void updateTaskState(Task task, TaskState newState) {
        if (task != null) {
            task.setState(newState);
            task.getState().handleState(task);
        }
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
