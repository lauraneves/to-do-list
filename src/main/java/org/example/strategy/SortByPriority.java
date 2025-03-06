package org.example.strategy;

import org.example.template.Task;
import java.util.List;

public class SortByPriority implements SortingStrategy {
    @Override
    public void sort(List<Task> tasks) {
        tasks.sort((t1, t2) -> Integer.compare(getPriority(t1), getPriority(t2)));
    }

    private int getPriority(Task task) {
        return switch (task.getCategory().toLowerCase()) {
            case "work" -> 1;
            case "study" -> 2;
            case "personal" -> 3;
            default -> 4;
        };
    }
}
