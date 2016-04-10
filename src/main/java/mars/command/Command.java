package mars.command;

import mars.model.Rover;

public interface Command {

    void execute(Rover rover);
}
