package org.example.template;

public class RecurringTask extends Task {
    private final int recurrenceDays;

    public RecurringTask(String title, String description, String category, int recurrenceDays) {
        super(title, description, category);
        this.recurrenceDays = recurrenceDays;
    }

    @Override
    public void completeTask() {
        System.out.println("[EXECUÇÃO] A tarefa '" + getTitle() + "' foi concluída, mas será repetida a cada " + recurrenceDays + " dias.");
    }
}
