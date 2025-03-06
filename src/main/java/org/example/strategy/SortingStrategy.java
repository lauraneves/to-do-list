package org.example.strategy;

import org.example.template.Task;
import java.util.List;

public interface SortingStrategy {
    void sort(List<Task> tasks);
}
