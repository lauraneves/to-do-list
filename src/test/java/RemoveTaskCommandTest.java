import org.example.command.RemoveTaskCommand;
import org.example.manager.TaskManager;
import org.example.template.Task;
import org.example.factory.PersonalTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveTaskCommandTest {
    private TaskManager manager;
    private Task task;
    private RemoveTaskCommand removeTaskCommand;

    @BeforeEach
    void setUp() {
        manager = TaskManager.getInstance();
        manager.getTasks().clear();

        task = new PersonalTask().createTask("Pessoal", "p3");
        manager.addTask(task);

        removeTaskCommand = new RemoveTaskCommand(manager, task);
    }

    @Test
    void testExecute() {
        removeTaskCommand.execute();
        assertFalse(manager.getTasks().contains(task));
    }

    @Test
    void testUndo() {
        removeTaskCommand.execute();
        removeTaskCommand.undo();
        assertTrue(manager.getTasks().contains(task));
    }
}
