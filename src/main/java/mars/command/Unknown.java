package mars.command;

import mars.model.Rover;

public class Unknown implements Command {

    @Override
    public void execute(Rover rover) {
        throw new UnsupportedOperationException("This command is not executable");
    }
}
