package org.example.chain;

import org.example.template.Task;

public class TitleValidation extends ValidationHandler {
    @Override
    public void validate(Task task) {
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] O título da tarefa não pode estar vazio!");
        }
        System.out.println("[VALIDAÇÃO] O título da tarefa está válido.");
        super.validate(task);
    }
}
