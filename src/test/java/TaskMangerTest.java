import org.example.manager.TaskManager;
import org.example.template.Task;
import org.example.factory.PersonalTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {
    private TaskManager manager;
    private Task task;

    @BeforeEach
    void setUp() {
        manager = TaskManager.getInstance();
        manager.getTasks().clear();
        task = new PersonalTask().createTask("Fazer compras", "...");
    }

    @Test
    void testAddTask() {
        manager.addTask(task);
        assertEquals(1, manager.getTasks().size());
        assertTrue(manager.getTasks().contains(task));
    }

    @Test
    void testRemoveTask() {
        manager.addTask(task);
        manager.removeTask(task);
        assertEquals(0, manager.getTasks().size());
    }

    @Test
    void testSingletonInstance() {
        TaskManager anotherInstance = TaskManager.getInstance();
        assertSame(manager, anotherInstance);
    }
}
