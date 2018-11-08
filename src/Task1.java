import domain.Task;
import domain.TaskType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.lang.System.out;

public class Task1 {
    public static void main(String[] args) {
        List<Task> tasks = Task.getTasks();
        Predicate<Task> readingTasks = t -> t.getType() == TaskType.READING;
        List<String> titles = taskTitles(tasks, readingTasks);
        titles.forEach(out::println);
    }

    private static List<String> taskTitles(List<Task> tasks, Predicate<Task> predicate) {
        List<String> titles = new ArrayList<>();
        Function<Task, String> function = Task::getTitle;
        for (Task task : tasks) {
            if (predicate.test(task)) {
                titles.add(function.apply(task));
            }
        }
        return titles;
    }
}
