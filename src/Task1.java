import static java.lang.System.*;

import domain.Task;
import domain.TaskType;
import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public static void main(String[] args) {
        List<Task> tasks = Task.getTasks();
        List<String> titles = taskTitles(tasks);
        for (String title : titles) {
            out.println(title);
        }
    }

    private static List<String> taskTitles(List<Task> tasks) {
        List<String> readingTitles = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getType() == TaskType.READING) {
                readingTitles.add(task.getTitle());
            }
        }
        return readingTitles;
    }

}
