package raythx98.duke.command;

import raythx98.duke.storage.Storage;
import raythx98.duke.task.TaskList;
import raythx98.duke.ui.Ui;

public class ExitCommand extends Command {

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        storage.save();
        System.exit(0);
        ui.farewell();
    }
    public boolean isExit() {
        return true;
    }
}