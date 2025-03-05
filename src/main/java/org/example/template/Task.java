package org.example.template;

import org.example.state.TaskState;
import org.example.state.PendingState;

public abstract class Task {
    protected String title;
    protected String description;
    protected String category;
    protected TaskState state;

    public Task(String title, String description, String category) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.state = new PendingState();
    }

    public final void executeTask() {
        validateTask();
        completeTask();
        notifyUser();
    }

    protected void validateTask() {
        System.out.println("[VALIDAÇÃO] Verificando a tarefa: " + title);
    }

    protected abstract void completeTask();

    protected void notifyUser() {
        System.out.println("[NOTIFICAÇÃO] Tarefa concluída: " + title);
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public TaskState getState() {
        return state;
    }
}
