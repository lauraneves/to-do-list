import org.example.TaskLogic;
import org.example.chain.TitleValidation;
import org.example.factory.PersonalTask;
import org.example.manager.TaskManager;
import org.example.mediator.TaskMediator;
import org.example.template.Task;
import org.example.state.PendingState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskLogicTest {
    private TaskLogic logic;
    private TaskManager manager;

    @BeforeEach
    void setUp() {
        manager = TaskManager.getInstance();
        manager.getTasks().clear();
        TaskMediator mediator = new TaskMediator(manager);
        logic = new TaskLogic(manager, new TitleValidation(), mediator);
    }

    @Test
    void testCreateValidTask() {
        Task task = logic.createValidTask(new PersonalTask(), "Terminar de ler o livro", "kindle");
        assertNotNull(task);
    }

    @Test
    void testAddTask() {
        Task task = new PersonalTask().createTask("Academia", "Treino com a personal");
        logic.addTask(task);
        assertEquals(1, manager.getTasks().size());
    }

    @Test
    void testUpdateTaskState() {
        Task task = new PersonalTask().createTask("Planejar viagem", "Conferir as hospedagens");
        logic.addTask(task);
        logic.updateTaskState(task, new PendingState());
        assertEquals(PendingState.class, task.getState().getClass());
    }
}
