package org.example.template;

    public class RecurringTask extends Task {
    private int recurrenceDays;

    public RecurringTask(String title, String description, String category, int recurrenceDays) {
        super(title, description, category);
        this.recurrenceDays = recurrenceDays;
    }

    @Override
    protected void completeTask() {
        System.out.println("[EXECUÇÃO] Concluindo tarefa recorrente: " + title + ". Se repetirá a cada " + recurrenceDays + " dias.");
    }
}
