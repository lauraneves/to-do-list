package org.example.command;

import org.example.manager.TaskManager;
import org.example.template.Task;

public class RemoveTaskCommand implements TaskCommand {
    private final TaskManager manager;
    private final Task task;

    public RemoveTaskCommand(TaskManager manager, Task task) {
        this.manager = manager;
        this.task = task;
    }

    @Override
    public void execute() {
        System.out.println("Removendo tarefa: " + task.getTitle());
        manager.removeTask(task);
    }

    @Override
    public void undo() {
        System.out.println("Desfazendo remoção da tarefa: " + task.getTitle());
        manager.addTask(task);
    }
}
