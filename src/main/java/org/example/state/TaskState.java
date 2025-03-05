package org.example.state;

import org.example.template.Task;

public interface TaskState {
    void handleState(Task task);
}
