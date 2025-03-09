import org.example.manager.TaskManager;
import org.example.mediator.TaskMediator;
import org.example.template.Task;
import org.example.factory.PersonalTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class TaskMediatorTest {
    private TaskMediator mediator;
    private TaskManager manager;
    private Task task;

    @BeforeEach
    void setUp() {
        manager = mock(TaskManager.class);
        mediator = new TaskMediator(manager);
        task = new PersonalTask().createTask("Praticar tecido", "Rever a queda, e treinar inversão");
    }

    @Test
    void testAddTaskWithNotification() {
        mediator.addTaskWithNotification(task);
        verify(manager, times(1)).addTask(task);
    }
}
