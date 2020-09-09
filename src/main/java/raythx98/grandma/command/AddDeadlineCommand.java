package raythx98.grandma.command;

import raythx98.grandma.exception.DukeException;
import raythx98.grandma.exception.WrongDescriptionException;
import raythx98.grandma.storage.Storage;
import raythx98.grandma.task.Deadline;
import raythx98.grandma.task.Task;
import raythx98.grandma.task.TaskList;
import raythx98.grandma.ui.Ui;

/**
 * Represents a Add Deadline Command.
 */
public class AddDeadlineCommand extends AddCommand {
    public AddDeadlineCommand(String taskDescriptionDeadline) {
        super(taskDescriptionDeadline);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] descriptionSplit = taskDescriptionDeadline.split(" /by ", 2);
        String[] hashtagSplit = descriptionSplit[0].split(" #", 2);
        Task task;
        if (descriptionSplit.length == 1) {
            task = new Deadline(hashtagSplit[0], hashtagSplit[1]);
        } else if (descriptionSplit.length == 2) {
            task = new Deadline(hashtagSplit[0], hashtagSplit[1], descriptionSplit[1]);
        } else {
            throw new WrongDescriptionException();
        }
        tasks.addTask(task);
        ui.appendMessage("Got it, here yur task bij\n    " + task.toString()
                + "\nNow you have " + tasks.getSize() + " tasks in the list.");
    }
}
