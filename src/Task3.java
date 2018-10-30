import static domain.Task.getTasks;
import static java.lang.System.*;

import domain.Task;
import domain.TaskType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();
        Map<TaskType, List<Task>> allTasksByType = new HashMap<>();
        for (Task task : tasks) {
            List<Task> existingTasksByType = allTasksByType.get(task.getType());
            if (existingTasksByType == null) {
                List<Task> tasksByType = new ArrayList<>();
                tasksByType.add(task);
                allTasksByType.put(task.getType(), tasksByType);
            } else {
                existingTasksByType.add(task);
            }
        }
        for (Map.Entry<TaskType, List<Task>> entry : allTasksByType.entrySet()) {
            out.println(String.format("%s =>> %s", entry.getKey(), entry.getValue()));
        }
    }
}
