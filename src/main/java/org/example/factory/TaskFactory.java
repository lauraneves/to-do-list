package org.example.factory;

import org.example.template.Task;

public abstract class TaskFactory {
    public abstract Task createTask(String title, String description);
}
