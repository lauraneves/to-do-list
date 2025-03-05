package org.example.chain;

import org.example.template.Task;

public abstract class ValidationHandler {
    protected ValidationHandler next;

    public void setNext(ValidationHandler next) {
        this.next = next;
    }

    public void validate(Task task) {
        if (next != null) {
            next.validate(task);
        }
    }
}
