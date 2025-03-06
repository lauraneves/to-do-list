package org.example;
import org.example.chain.DateValidation;
import org.example.chain.TitleValidation;
import org.example.factory.StudyTask;
import org.example.factory.WorkTask;
import org.example.manager.TaskManager;
import org.example.factory.TaskFactory;
import org.example.factory.PersonalTask;
import org.example.state.CompletedState;
import org.example.state.InProgressState;
import org.example.mediator.TaskMediator;
import org.example.chain.ValidationHandler;
import org.example.strategy.SortByDate;
import org.example.strategy.SortByPriority;
import org.example.strategy.TaskSorter;
import org.example.template.RecurringTask;
import org.example.template.Task;

public class Main {
    public static void main(String[] args) {
        System.out.println("========");

        TaskManager manager = TaskManager.getInstance();    // Singleton
        TaskMediator mediator = new TaskMediator(manager);

        ValidationHandler titleValidation = new TitleValidation();  //Chain - regras de validação
        ValidationHandler dateValidation = new DateValidation();
        titleValidation.setNext(dateValidation);

        TaskLogic logic = new TaskLogic(manager, titleValidation, mediator);  //arquivo aux

        TaskFactory personalFactory = new PersonalTask();
        TaskFactory studyFactory = new StudyTask();
        TaskFactory workFactory = new WorkTask();

        Task firstPersonalTask = logic.createValidTask(personalFactory, "Ir ao mercado", "Lista de compras: x, y, z");
        Task firstStudyTask = logic.createValidTask(studyFactory, "Fazer tarefa do Marco", "aspectos avançados em ...");
        Task firstWorkTask = logic.createValidTask(workFactory, "Revisar datomic", "#slack-channel");
        Task firstRecurringTask = new RecurringTask("Academia", "repete 3x/semana", "Pessoal", 3);

        logic.addTask(firstPersonalTask);
        logic.addTask(firstStudyTask);
        logic.addTask(firstWorkTask);
        logic.addTask(firstRecurringTask);

        manager.printTasks();

        logic.updateTaskState(firstWorkTask, new InProgressState());
        logic.updateTaskState(firstStudyTask, new CompletedState());


        logic.removeTask(firstPersonalTask);
        logic.undoRemovedTask(firstPersonalTask);


        TaskSorter sorter = new TaskSorter();
        sorter.setStrategy(new SortByPriority());
        sorter.sort(manager.getTasks());

        System.out.println("\n[ORDENAÇÃO] Ordenado por prioridade:");
        manager.printTasks();

        sorter.setStrategy(new SortByDate());
        sorter.sort(manager.getTasks());

        System.out.println("\n[ORDENAÇÃO] Ordenado por data de criação:");
        manager.printTasks();

        System.out.println("========");
    }
}