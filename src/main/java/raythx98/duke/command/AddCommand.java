package raythx98.duke.command;

import raythx98.duke.exception.DukeException;
import raythx98.duke.storage.Storage;
import raythx98.duke.task.TaskList;
import raythx98.duke.ui.Ui;

public abstract class AddCommand extends Command {
    protected final String taskDescriptionDeadline;
    public AddCommand(String taskDescriptionDeadline) {
        this.taskDescriptionDeadline = taskDescriptionDeadline;
    }
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
}