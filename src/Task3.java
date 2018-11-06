import static domain.Task.getTasks;
import static java.lang.System.*;

import domain.Task;
import domain.TaskType;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Task3 {

    private static final List<Task> TASKS = getTasks();

    public static void main(String[] args) {

        //Subtask 1
        out.println(longestTaskTitle());
        out.println("\n");

        //Subtask 2
        out.println(totalTagNumber());
        out.println("\n");

        //Subtask 3
        out.println(titlesSummary());
        out.println("\n");

        //Subtask 4 / Refactored main method
        allTasksByType().forEach((key, value) -> out.println(String.format("%s =>> %s", key, value)));
        out.println("\n");

        //Subtask 5
        allTasksByTypeAndDate().forEach((key, value) -> out.println(String.format("%s =>> %s", key, value)));
    }

    //Finding Task with longest title
    private static String longestTaskTitle() {
        return TASKS
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getTitle().length(), t1.getTitle().length()))
                .limit(1)
                .map(Task::getTitle)
                .collect(Collectors.joining());
    }

    //Count total number of tags
    private static long totalTagNumber() {
        return TASKS
                .stream()
                .mapToLong(t -> t.getTags().size())
                .sum();
    }

    //Generate summary of Task titles
    private static String titlesSummary() {
        return TASKS
                .stream()
                .map(Task::getTitle)
                .collect(Collectors.joining(";"));
    }

    //Grouping tasks by type
    private static Map<TaskType, List<Task>> allTasksByType() {
        return TASKS
                .stream()
                .collect(Collectors.groupingBy(Task::getType));
    }

    //Grouping by TaskType and createdOn
    private static Map<TaskType, Map<LocalDate, List<Task>>> allTasksByTypeAndDate() {
        return TASKS
                .stream()
                .collect(Collectors.groupingBy(Task::getType,
                        Collectors.groupingBy(Task::getCreatedOn)));
    }
}
