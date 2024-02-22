package duke.Command;

import duke.TaskList;
import duke.Task.Task;
import java.util.ArrayList;
import duke.DukeException;

public class EditCommand extends Command{
    
    public EditCommand() {
       

    }

    @Override
    public String execute(TaskList taskList, String command) throws DukeException {
        // Split the command string into parts using space as delimiter
        String[] parts = command.split(" ", 2); // Limit the split to 2 parts

        // Check if the command is properly formatted
        if (parts.length != 2 || !parts[0].equalsIgnoreCase("edit")) {
            throw new DukeException("Invalid edit command format. Please use: edit <index> <new description>");
        }

        // Extract the index and new description from the second part of the command
        String[] parts2 = parts[1].split(" ", 2); // Limit the split to 2 parts
        if (parts2.length != 2) {
            throw new DukeException("Invalid edit command format. Please use: edit <index> <new description>");
        }
        int index;
        try {
            index = Integer.parseInt(parts2[0].trim());
        } catch (NumberFormatException e) {
            throw new DukeException("Invalid task index. Please enter a valid number.");
        }
        String newDescription = parts2[1].trim();

        // Perform the edit operation using the extracted index and new description
        if (index < 1 || index > taskList.getTasks().size()) {
            throw new DukeException("Invalid task index. Please enter a valid number.");
        }
        Task task = taskList.getTasks().get(index - 1);
        task.setDescription(newDescription);

        return "Task " + index + " has been successfully edited:\n" + task.toString();
    }
        
}
