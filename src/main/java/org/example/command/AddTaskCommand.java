package org.example.command;

import org.example.manager.TaskManager;
import org.example.template.Task;

public class AddTaskCommand implements TaskCommand {
    private final TaskManager manager;
    private final Task task;

    public AddTaskCommand(TaskManager manager, Task task) {
        this.manager = manager;
        this.task = task;
    }

    @Override
    public void execute() {
        System.out.println("Adicionando tarefa: " + task.getTitle());
        manager.addTask(task);
    }

    @Override
    public void undo() {
        System.out.println("Desfazendo adição da tarefa: " + task.getTitle());
        manager.removeTask(task);
    }
}
