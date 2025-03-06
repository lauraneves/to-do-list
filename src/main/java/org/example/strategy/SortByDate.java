package org.example.strategy;

import org.example.template.Task;
import java.util.List;

public class SortByDate implements SortingStrategy {
    @Override
    public void sort(List<Task> tasks) {
        tasks.sort((t1, t2) -> t1.getCreationDate().compareTo(t2.getCreationDate()));
    }
}
