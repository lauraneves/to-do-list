package org.example.state;

import org.example.template.Task;

public class PendingState implements TaskState {
    @Override
    public void handleState(Task task) {
        System.out.println("[ESTADO] A tarefa '" + task.getTitle() + "' está pendente.");
    }
}
