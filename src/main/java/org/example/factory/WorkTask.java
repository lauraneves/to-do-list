package org.example.factory;

import org.example.template.ConcreteTask;
import org.example.template.Task;

public class WorkTask extends TaskFactory {
    @Override
    public Task createTask(String title, String description) {
        return new ConcreteTask(title, description, "Trabalho");
    }
}
