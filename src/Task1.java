import static java.lang.System.*;
import domain.Task;
import domain.TaskType;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task1 {

    public static void main(String[] args) {
        List<Task> tasks = Task.getTasks();
        List<String> titles = taskTitles(tasks);
        titles.forEach(out::println);
    }

    private static List<String> taskTitles(List<Task> tasks) {

        Predicate<Task> readingTasks = t -> t.getType()==TaskType.READING;

        return tasks
                .stream()
                .filter(readingTasks)
                .map(Task::getTitle)
                .collect(Collectors.toList());

    }

}
