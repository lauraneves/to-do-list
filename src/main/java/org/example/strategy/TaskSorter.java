package org.example.strategy;

import org.example.template.Task;
import java.util.List;

public class TaskSorter {
    private SortingStrategy strategy;   // Strategy

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(List<Task> tasks) {
        if (strategy != null) {
            strategy.sort(tasks);
        }
    }
}
