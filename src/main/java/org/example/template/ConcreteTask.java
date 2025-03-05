package org.example.template;

public class ConcreteTask extends Task {
    public ConcreteTask(String title, String description, String category) {
        super(title, description, category);
    }

    @Override
    protected void completeTask() {
        System.out.println("[EXECUÇÃO] Tarefa '" + title + "' concluída.");
    }
}
