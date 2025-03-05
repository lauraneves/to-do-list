package org.example.chain;

import org.example.template.Task;

public class DateValidation extends ValidationHandler {
    @Override
    public void validate(Task task) {
        // todo: implementar validação
        System.out.println("[VALIDAÇÃO] Data da tarefa validada com sucesso.");
        super.validate(task);
    }
}
