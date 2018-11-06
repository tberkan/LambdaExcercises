import domain.Task;
import domain.TaskType;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Task2 {

    private static final List<Task> TASKS = Task.getTasks();
    private static final Predicate<Task> READING_TASKS_PREDICATE = t -> t.getType() == TaskType.READING;

    public static void main(String[] args) {

        //Refactored main method
        List<String> readingTasks = TASKS
                .stream()
                .filter(READING_TASKS_PREDICATE)
                .sorted(Comparator.comparingInt(t -> t.getTitle().length()))
                .map(Task::getTitle)
                .collect(Collectors.toList());
        readingTasks.forEach(out::println);
        out.println("\n");

        //Subtask 1
        readingTaskTitles().forEach(out::println);
        out.println("\n");

        //Subtask 2
        readingTaskReverse().forEach(out::println);
        out.println("\n");

        //Subtask 3
        distinctTasks().forEach(out::println);
        out.println("\n");

        //Subtask 4
        topTwoReadingTasks().forEach(out::println);
        out.println("\n");

        //Subtask 5
        uniqueTags().forEach(out::println);
        out.println("\n");

        //Subtask 6
        out.println(readingTagBooks());
        out.println("\n");

        //Subtask 7
        titlesSummary().forEach(out::println);
    }

    //Find all reading task titles sorted by their creation date.
    private static List<String> readingTaskTitles() {
        return TASKS
                .stream()
                .filter(READING_TASKS_PREDICATE)
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .map(Task::getTitle)
                .collect(Collectors.toList());
    }

    //Find all reading tasks sorted by creation date in reverse.
    private static List<Task> readingTaskReverse() {
        return TASKS
                .stream()
                .filter(READING_TASKS_PREDICATE)
                .sorted(Comparator.comparing(Task::getCreatedOn).reversed())
                .collect(Collectors.toList());
    }

    //Find distinct tasks.
    private static List<Task> distinctTasks() {
        return TASKS
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    //Find top 2 reading tasks sorted by creation date.
    private static List<Task> topTwoReadingTasks() {
        return TASKS
                .stream()
                .filter(READING_TASKS_PREDICATE)
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .limit(2)
                .collect(Collectors.toList());
    }

    //Find all unique tags from all tasks.
    private static Set<String> uniqueTags() {
        return TASKS
                .stream()
                .flatMap(t -> t.getTags().stream())
                .collect(Collectors.toSet());
    }

    //Check if all reading tasks have tag books.
    private static boolean readingTagBooks() {
        return TASKS
                .stream()
                .filter(READING_TASKS_PREDICATE)
                .noneMatch(t -> t.getTags().isEmpty());
    }

    //Creating a summary of all titles.
    private static List<String> titlesSummary() {
        return TASKS
                .stream()
                .map(Task::getTitle)
                .collect(Collectors.toList());
    }
}