package org.example.state;

import org.example.template.Task;

public class InProgressState implements TaskState {
    @Override
    public void handleState(Task task) {
        System.out.println("[ESTADO] A tarefa '" + task.getTitle() + "' está em progresso.");
    }
}
